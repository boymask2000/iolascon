package query;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class QueryXmlParser {

	private String xml;

	public QueryXmlParser(String xml) {
		this.xml = xml;
	}

	public List<CampoQuery> parse() throws Exception {
		List<CampoQuery> lista = new ArrayList<CampoQuery>();

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(xml));

		Document doc = dBuilder.parse(is);
		doc.getDocumentElement().normalize();

		Element root = doc.getDocumentElement();

		NodeList nodeList = root.getChildNodes();

		// NodeList nList = doc.getElementsByTagName("query");
		try {
			for (int temp = 0; temp < nodeList.getLength(); temp++) {

				Node nNode = nodeList.item(temp);

				CampoQuery campoQuery = new CampoQuery();

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					System.out.println("\nCurrent Element :" + nNode.getNodeName());
					Element eElement = (Element) nNode;

					String tabella = eElement.getElementsByTagName("tabella").item(0).getTextContent();
					String campo = eElement.getElementsByTagName("campo").item(0).getTextContent();

					campoQuery.setTabella(tabella);
					campoQuery.setCampo(campo);

					NodeList eqEl = eElement.getElementsByTagName("equalsTo");
					if (eqEl.getLength() > 0) {
						campoQuery.setEqualTo(true);
						String val = eqEl.item(0).getTextContent();
						campoQuery.setEqualToValue(val);
					}
					NodeList gtEl = eElement.getElementsByTagName("greaterThan");
					if (gtEl.getLength() > 0) {
						campoQuery.setGreaterThen(true);
						String val = gtEl.item(0).getTextContent();
						campoQuery.setGreaterThenValue(val);
					}
					NodeList ltEl = eElement.getElementsByTagName("lessThan");
					if (ltEl.getLength() > 0) {
						campoQuery.setLessThen(true);
						String val = ltEl.item(0).getTextContent();
						campoQuery.setLessThenValue(val);
					}
					NodeList gto = eElement.getElementsByTagName("goToOutput");
					if (gto.getLength() > 0) {
						campoQuery.setGoToOutput(true);
						String val = ltEl.item(0).getTextContent();
						
					}

				}
				lista.add(campoQuery);
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return lista;
	}
}
