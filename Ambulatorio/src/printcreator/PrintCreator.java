package printcreator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import beans.BasicDocumentViewController;
import beans.JsfUtil;
import common.AmbUtils;
import common.TempFileFactory;

public class PrintCreator {
	private StringBuffer buffer = new StringBuffer();
	public static PageFormat PORTRAT = new PageFormat("PORTRAT");
	public static PageFormat LANDSCAPE = new PageFormat("LANDSCAPE");

	private List<PageFormat> pageFormats = new ArrayList<PageFormat>();

	public PrintCreator() {
		pageFormats.add(PORTRAT);
		LANDSCAPE.setOrientation("90");
		pageFormats.add(LANDSCAPE);
	}

	public void build() {
		insertStartDoc();
		insertPageFormats();

		insertFineDoc();
	}

	public void insertPageFormats() {
		buffer.append("<fo:layout-master-set>");
		for (PageFormat f : pageFormats)
			buffer.append(f.getBuffer());
		buffer.append("</fo:layout-master-set>");
	}

	private boolean startedPageSequence = false;

	public void startPageSequence(PageFormat pf) {
		if (pf == null)
			pf = PORTRAT;

		buffer.append("<fo:page-sequence master-reference=\"" + pf.getName() + "\">");
		buffer.append("<fo:flow flow-name=\"xsl-region-body\">");
		startedPageSequence = true;
	}

	public void endPageSequence() {
		if (!startedPageSequence)
			return;
		startedPageSequence = false;
		buffer.append("</fo:flow>");
		buffer.append("</fo:page-sequence>");

	}

	public void insertStartDoc() {
		buffer.append("<fo:root xmlns:fo=\"http://www.w3.org/1999/XSL/Format\">");

	}

	public void insertFineDoc() {
		buffer.append("</fo:root>");

	}

	public void addBlock(String s, String size) {
		buffer.append("<fo:block font-size=\"" + size + "\">");
		buffer.append(s);
		buffer.append("</fo:block>");

	}

	public void addtable(Table t) {
		buffer.append(t.getBuffer());
	}

	public InputStream getBufferInputStream() {
		return new ByteArrayInputStream(buffer.toString().getBytes());
	}

	private void dump() {

		System.out.println(buffer.toString());

	}

	public void addImage(byte[] photo) {
		try {
			File temp = File.createTempFile("img", ".jpg");
			FileOutputStream fos = new FileOutputStream(temp);

			fos.write(photo);
			fos.flush();
			fos.close();
			URL url = temp.toURI().toURL();

			buffer.append("<fo:block >");
			buffer.append("<fo:external-graphic src=\"" + url.toString() + "\"/>");
			// buffer.append("<fo:external-graphic
			// src=\"url('data:image/jpeg;base64,"+url.toString()+"')/>");
			buffer.append("</fo:block>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// buffer.append("<fo:block >");
		// buffer.append("<fo:external-graphic
		// src=\"url('data:image/jpeg;base64,"+AmbUtils.convertToBase64(photo)+"')/>");
		// buffer.append("</fo:block>");

	}

	public static void main(String s[]) {
		PrintCreator prt = new PrintCreator();
		prt.insertStartDoc();
		prt.insertPageFormats();

		prt.startPageSequence(null);
		prt.addBlock("Elenco", "30pt");
		Table t = new Table();
		t.setHeader(false);
		t.addColumnDefinition(new Column("name", "2cm"));
		t.addColumnDefinition(new Column("cognome", "2cm"));

		for (int i = 0; i < 300; i++) {
			t.startRow();
			t.addDataCol("giovanni" + i);
			t.addDataCol("posa");
		}

		prt.addtable(t);
		prt.endPageSequence();
		prt.insertFineDoc();

		prt.dump();
	}


	public void convertToPDFNEW(InputStream is) throws IOException, FOPException, TransformerException {
		// the XSL FO file
		// File xsltFile = getFile("print/template/lista_pazienti.xsl");
		File xsltFile = new File("/home/giovanni/Desktop/fop-2.3/fop/prova.xsl");
		// the XML file which provides the input

		// create an instance of fop factory
		FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
		// a user agent is needed for transformation
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
		// Setup output
		OutputStream out;
		File tempPdf=TempFileFactory.getTempFile(".pdf");
		out = new java.io.FileOutputStream(tempPdf);

		try {
			// Construct fop with desired output format
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

			// Setup XSLT
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();

			// Resulting SAX events (the generated FO) must be piped through to FOP
			Result res = new SAXResult(fop.getDefaultHandler());

			// Start XSLT transformation and FOP processing
			// That's where the XML is first transformed to XSL-FO and then
			// PDF is created
			Source src = new StreamSource(is);
			transformer.transform(src, res);
		} finally {
			out.close();
		}
		BasicDocumentViewController view = (BasicDocumentViewController) JsfUtil.getBean("basicDocumentViewController");
		view.setPdf(tempPdf);
	//	TempFileFactory.clean();
	}

	public List<Pair> caricaCampi(Object bean) {
		List<Pair> lista = new ArrayList<Pair>();
		try {
			Field[] ll = bean.getClass().getDeclaredFields();
			for (Field f : ll) {
				String name = f.getName();
				String type = f.getType().getName();

				if (name.equals("id"))
					continue;
				if (name.equals("n"))
					continue;
				if (!type.equals("int") && !type.equals("java.lang.String") && !type.equals("java.util.Date"))
					continue;

				String methodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
				Method meth = bean.getClass().getDeclaredMethod(methodName, null);
				System.out.println(meth.getName());
				Object val = meth.invoke(bean, null);
				System.out.println(val);
				if (val == null)
					val = "";
				if (val instanceof Date)
					val = AmbUtils.formatDate((Date) val);
				lista.add(new Pair(name, val, type));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return lista;
	}

}
