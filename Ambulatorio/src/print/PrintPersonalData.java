package print;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

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
import common.Utils;
import database.DBUtil;

public class PrintPersonalData extends Print {

	public String convertPersonalDataToPDF() {

		DBUtil db = getBeanDBUtil();

		PersonalData pers = db.getSelectedPersonalData();

		InputStream is = convertSelectedPersonalData(pers);

		File xsltFile = getFile("print/template/personalData.xsl");
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

	private InputStream convertSelectedPersonalData(PersonalData pers) {
		try {
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			DBUtil db = (DBUtil) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext,
					null, "dBUtil");

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();

			Element rootElement = doc.createElement("personalData");
			doc.appendChild(rootElement);

			convertPersonalData(doc, rootElement, pers);

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

	public void convertPersonalData(Document doc, Element rootElement, PersonalData p) {
		// staff elements
		Element staff = doc.createElement("paziente");
		rootElement.appendChild(staff);
		Attr attr = doc.createAttribute("id");
		attr.setValue("1");
		staff.setAttributeNode(attr);

		Element ii = doc.createElement("id");
		ii.appendChild(doc.createTextNode("" + p.getN()));
		staff.appendChild(ii);

		Element firstname = doc.createElement("name");
		firstname.appendChild(doc.createTextNode(p.getName()));
		staff.appendChild(firstname);

		// lastname elements
		Element lastname = doc.createElement("surname");
		lastname.appendChild(doc.createTextNode(p.getSurname()));
		staff.appendChild(lastname);
		
		
		
		
		
		
		Element e1 = doc.createElement("familial_degree");
		e1.appendChild(doc.createTextNode(p.getFamilial_degree()));
		staff.appendChild(e1);
		
		Element e2 = doc.createElement("consanguinity");
		e2.appendChild(doc.createTextNode(p.getConsanguinity()));
		staff.appendChild(e2);
		
		Element e4 = doc.createElement("withdrawal");
		e4.appendChild(doc.createTextNode(Utils.formatDate(p.getWithdrawal())));
		staff.appendChild(e4);
		
		Element e3 = doc.createElement("acceptance");
		e3.appendChild(doc.createTextNode(Utils.formatDate(p.getAcceptance())));
		staff.appendChild(e3);
		
		Element e5 = doc.createElement("codeEthnicity");
		e5.appendChild(doc.createTextNode(p.getCodeEthnicity()));
		staff.appendChild(e5);
		
		Element e6 = doc.createElement("dob");
		e6.appendChild(doc.createTextNode(p.getDob()));
		staff.appendChild(e6);
		
		Element e7 = doc.createElement("place_of_residence");
		e7.appendChild(doc.createTextNode(p.getPlace_of_residence()));
		staff.appendChild(e7);
		
		Element e8 = doc.createElement("reference_doctor");
		e8.appendChild(doc.createTextNode(""+p.getReference_doctor()));
		staff.appendChild(e8);
		
		Element e9 = doc.createElement("initial_clinical");
		e9.appendChild(doc.createTextNode(""+p.getInitial_clinical()));
		staff.appendChild(e9);
		
		Element w1 = doc.createElement("age_at_diagnosis");
		w1.appendChild(doc.createTextNode(""+p.getAge_at_diagnosis()));
		staff.appendChild(w1);
		
		Element w2 = doc.createElement("onset_symptoms");
		w2.appendChild(doc.createTextNode(p.getOnset_symptoms()));
		staff.appendChild(w2);
		
		Element w3 = doc.createElement("age_onset_symptoms");
		w3.appendChild(doc.createTextNode(""+p.getAge_onset_symptoms()));
		staff.appendChild(w3);
		
	
	}
}
