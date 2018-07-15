package print;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import beans.HematologicData;
import beans.PersonalData;
import beans.SurgicalIntervention;
import common.Utils;
import database.DBUtil;

public class PrintSchedaPaziente extends Print {

	public String convertSchedaPazienteToPDF() {
		DBUtil db = getBeanDBUtil();

		PersonalData pers = db.getSelectedPersonalData();

		InputStream is = convertSchedaPaziente(pers);

		File xsltFile = getFile("print/template/schedaPaziente.xsl");
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

	private InputStream convertSchedaPaziente(PersonalData pers) {
		try {
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			DBUtil db = (DBUtil) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext,
					null, "dBUtil");

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();

			Element rootElement = doc.createElement("schedaPaziente");
			doc.appendChild(rootElement);

			PrintPersonalData ppd = new PrintPersonalData();
			ppd.convertPersonalData(doc, rootElement, pers);

			convertSurgical(doc, rootElement, db.getSurgicalIntervention());
			convertHematologic(doc, rootElement, db.getElencoEmatologic());

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			Source xmlSource = new DOMSource(doc);
			Result outputTarget = new StreamResult(outputStream);
			TransformerFactory.newInstance().newTransformer().transform(xmlSource, outputTarget);

			// toFile(xmlSource);

			return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void toFile(Source xmlSource) throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		StreamResult result = new StreamResult(new File("/home/giovanni/Desktop/file.xml"));
		transformer.transform(xmlSource, result);

	}

	private void convertSurgical(Document doc, Element rootElement, SurgicalIntervention p) {
		Element staff = doc.createElement("surgical");
		rootElement.appendChild(staff);

		Element ii = doc.createElement("Splenectomy_YN");
		ii.appendChild(doc.createTextNode("" + p.getSplenectomy_YN()));
		staff.appendChild(ii);

	}

	private void convertHematologic(Document doc, Element rootElement, List<HematologicData> list) {

		for (HematologicData d : list) {
			Element staff = null;
			List<Pair> ll = caricaCampi("", "", d);
			if (ll != null && ll.size() > 0) {
				staff = doc.createElement("hematologic");
				rootElement.appendChild(staff);
			}
			for (Pair pa : ll) {
				Element ii = doc.createElement(pa.getName());
				ii.appendChild(doc.createTextNode("" + pa.getVal()));
				staff.appendChild(ii);
			}

		}
	}
}
