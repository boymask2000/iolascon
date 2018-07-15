package printcreator;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.faces.context.FacesContext;
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

import database.DBUtil;

public class PrintCreator {
	private StringBuffer buffer = new StringBuffer();
	private PageFormat portrait = new PageFormat("PORTRAT");

	private List<PageFormat> pageFormats = new ArrayList<PageFormat>();

	public PrintCreator() {
		pageFormats.add(portrait);

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
		if (pf == null) {
			buffer.append("<fo:page-sequence master-reference=\"" + portrait.getName() + "\">");
		} else
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

	public static void main(String s[]) {
		PrintCreator prt = new PrintCreator();
		prt.insertStartDoc();
		prt.insertPageFormats();

		prt.startPageSequence(null);
prt.addBlock("Elenco", "30pt");
		Table t = new Table();
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
	public DBUtil getBeanDBUtil() {

		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		DBUtil db = (DBUtil) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext,
				null, "dBUtil");
		return db;
	}
	public void convertToPDFNEW(InputStream is) throws IOException, FOPException, TransformerException {
		// the XSL FO file
		//File xsltFile = getFile("print/template/lista_pazienti.xsl"); 
		File xsltFile = new File( "/home/giovanni/Desktop/fop-2.3/fop/prova.xsl");
		// the XML file which provides the input
	
	
		// create an instance of fop factory
		FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
		// a user agent is needed for transformation
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
		// Setup output
		OutputStream out;
		out = new java.io.FileOutputStream("F:\\Temp\\employee.pdf");

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
	}
}
