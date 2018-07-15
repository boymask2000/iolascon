package query;

import java.io.StringWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class QueryXml {
	public String queryToXml(QueryHandler query) throws Exception {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();

		dumpQuery(doc, query);

		String out = writeToString(doc);

		System.out.println(out);
		return out;

	}

	private void dumpQuery(Document doc, QueryHandler query) {
		Element rootElement = doc.createElement("query");
		doc.appendChild(rootElement);

		List<CampoQuery> lista = query.getLista();
		for (CampoQuery c : lista) {
			if (!c.isSelected() && !c.isGoToOutput())
				continue;
			// staff elements
			Element staff = doc.createElement("CampoQuery");
			rootElement.appendChild(staff);

			Element campo = doc.createElement("campo");
			campo.appendChild(doc.createTextNode(c.getCampo()));
			staff.appendChild(campo);
			Element tabella = doc.createElement("tabella");
			tabella.appendChild(doc.createTextNode(c.getTabella()));
			staff.appendChild(tabella);
			if( c.isGoToOutput()) {
				Element eq = doc.createElement("goToOutput");
				eq.appendChild(doc.createTextNode("yes"));
				staff.appendChild(eq);
			}
			if (c.isEqualTo()) {
				Element eq = doc.createElement("equalsTo");
				eq.appendChild(doc.createTextNode(c.getEqualToValue().toString()));
				staff.appendChild(eq);
			}
			if (c.isGreaterThen()) {
				Element eq = doc.createElement("greaterThan");
				eq.appendChild(doc.createTextNode(c.getGreaterThenValue().toString()));
				staff.appendChild(eq);
			}
			if (c.isLessThen()) {
				Element eq = doc.createElement("lessThan");
				eq.appendChild(doc.createTextNode(c.getLessThenValue().toString()));
				staff.appendChild(eq);
			}

		}

	}

	private String writeToString(Document doc) throws Exception {
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);

		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(doc), new StreamResult(writer));
		String output = writer.getBuffer().toString().replaceAll("\n|\r", "");
		return output;
	}
}
