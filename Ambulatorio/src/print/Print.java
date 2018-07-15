package print;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import common.AmbUtils;
import database.DBUtil;

public class Print {

	public static void main(String[] args) {
		Print fOPPdfDemo = new Print();
		try {
			fOPPdfDemo.convertToPDFNEW();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	protected File getFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		URL dd = classLoader.getResource(fileName);
		File file = new File(dd.getFile());
		return file;
	}

	public void convertBean(String name, Object bean, Document doc, Element rootElement) {
		Element staff = doc.createElement(name);
		rootElement.appendChild(staff);

		caricaCampi("", "", bean);

	}

	public  List<Pair> caricaCampi(String tabella, String className, Object bean) {
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

				String methodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
				Method meth = bean.getClass().getDeclaredMethod(methodName, null);
				System.out.println(meth.getName());
				Object val = meth.invoke(bean, null);
				System.out.println(val);
				if( val==null)val="";
				if( val instanceof Date)
					val=AmbUtils.formatDate((Date)val);
				lista.add(new Pair(name, val));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return lista;
	}

	/**
	 * Method that will convert the given XML to PDF
	 * 
	 * @throws IOException
	 * @throws FOPException
	 * @throws TransformerException
	 */
	public DBUtil getBeanDBUtil() {

		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		DBUtil db = (DBUtil) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext,
				null, "dBUtil");
		return db;
	}

	public void convertToPDFNEW() throws IOException, FOPException, TransformerException {
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
			 Source src = new StreamSource(xsltFile);
			transformer.transform(src, res);
		} finally {
			out.close();
		}
	}

	public void convertToPDF() throws IOException, FOPException, TransformerException {
		// the XSL FO file
		File xsltFile = getFile("print/template/lista_pazienti.xsl"); // new File("F:\\Temp\\template.xsl");
		// the XML file which provides the input
		File f1 = getFile("print/sourcedata/employee.xml"); //
		StreamSource xmlSource = new StreamSource(f1); // new File("F:\\Temp\\Employees.xml"));
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
			Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

			// Resulting SAX events (the generated FO) must be piped through to FOP
			Result res = new SAXResult(fop.getDefaultHandler());

			// Start XSLT transformation and FOP processing
			// That's where the XML is first transformed to XSL-FO and then
			// PDF is created
			transformer.transform(xmlSource, res);
		} finally {
			out.close();
		}
	}

	public String convertToPDF(File xsltFile, StreamSource xmlSource)
			throws IOException, FOPException, TransformerException {

		FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
		// a user agent is needed for transformation
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
		// Setup output
		// OutputStream out;

		OutputStream out = new java.io.FileOutputStream("/home/giovanni/Desktop/employee.pdf");

		try {
			// Construct fop with desired output format
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

			// Setup XSLT
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

			// Resulting SAX events (the generated FO) must be piped through to FOP
			Result res = new SAXResult(fop.getDefaultHandler());

			// Start XSLT transformation and FOP processing
			// That's where the XML is first transformed to XSL-FO and then
			// PDF is created
			transformer.transform(xmlSource, res);
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			out.close();
		}
		return "/home/giovanni/Desktop/employee.pdf";
	}

	public void downloadPdf(InputStream pdfInputStream) throws IOException {
		// Get the FacesContext
		FacesContext facesContext = FacesContext.getCurrentInstance();

		// Get HTTP response
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

		// Set response headers
		response.reset(); // Reset the response in the first place
		response.setHeader("Content-Type", "application/pdf"); // Set only the content type

		// Open response output stream
		OutputStream responseOutputStream = response.getOutputStream();

		// Read PDF contents
		// URL url = new URL(PDF_URL);
		// InputStream pdfInputStream = url.openStream();
		//
		// Read PDF contents and write them to the output
		byte[] bytesBuffer = new byte[2048];
		int bytesRead;
		while ((bytesRead = pdfInputStream.read(bytesBuffer)) > 0) {
			responseOutputStream.write(bytesBuffer, 0, bytesRead);
		}

		// Make sure that everything is out
		responseOutputStream.flush();

		// Close both streams
		pdfInputStream.close();
		responseOutputStream.close();

		// JSF doc:
		// Signal the JavaServer Faces implementation that the HTTP response for this
		// request has already been generated
		// (such as an HTTP redirect), and that the request processing lifecycle should
		// be terminated
		// as soon as the current phase is completed.
		facesContext.responseComplete();

	}
}
