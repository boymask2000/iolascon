package print;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import beans.PersonalData;
import database.DBUtil;

public class PrintElenco extends Print{
	public String convertListaPazientiToPDF() { // List<PersonalData> lista) {
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		DBUtil db = (DBUtil) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext,
				null, "dBUtil");

		List<PersonalData> lista = db.getPazienti();
		InputStream is = convertListaPazientiToXML(lista);

		File xsltFile = getFile("print/template/lista_pazienti.xsl");
		// Faces.sendFile(file, true);
		StreamSource xmlSource = new StreamSource(is);
		try {
			String path = convertToPDF(xsltFile, xmlSource);
			File f = new File(path);

			// Faces.sendFile(f, false);
			downloadPdf(new FileInputStream(f));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private InputStream convertListaPazientiToXML(List<PersonalData> lista) {
		try {
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			DBUtil db = (DBUtil) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext,
					null, "dBUtil");

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();

			Element rootElement = doc.createElement("pazienti");
			doc.appendChild(rootElement);

			Element qq = doc.createElement("query");
			qq.appendChild(doc.createTextNode(db.getCurrentSelectionDesc()));
			rootElement.appendChild(qq);

			for (PersonalData p : lista) {
				convertPersonalData(doc, rootElement, p);

			}

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			Source xmlSource = new DOMSource(doc);
			Result outputTarget = new StreamResult(outputStream);
			TransformerFactory.newInstance().newTransformer().transform(xmlSource, outputTarget);
			return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void convertPersonalData(Document doc, Element rootElement, PersonalData p) {
		// staff elements
		Element staff = doc.createElement("paziente");
		rootElement.appendChild(staff);
		Attr attr = doc.createAttribute("id");
		attr.setValue("1");
		staff.setAttributeNode(attr);
		
		Element ii = doc.createElement("id");
		ii.appendChild(doc.createTextNode(""+p.getN()));
		staff.appendChild(ii);

		Element firstname = doc.createElement("name");
		firstname.appendChild(doc.createTextNode(p.getName()));
		staff.appendChild(firstname);

		// lastname elements
		Element lastname = doc.createElement("surname");
		lastname.appendChild(doc.createTextNode(p.getSurname()));
		staff.appendChild(lastname);
	}
}
