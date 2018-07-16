package query;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import beans.JsfUtil;
import beans.PersonalData;
import beans.Query;
import database.DBUtil;
import database.dao.MyBatisConnectionFactory;

public class QueryHandler {
	private String description;
	private List<CampoQuery> lista = new ArrayList<CampoQuery>();

	public QueryHandler() {
		caricaClassi();
	}

	public void addCampo(CampoQuery c) {
		lista.add(c);
	}

	public List<CampoQuery> getLista() {
//		lista.clear();
//		caricaClassi();
		return lista;
	}

	public void setCampoLessThen(String tab, String campo, Object val) {
		CampoQuery c = cercaCampo(tab, campo);
		if (c != null) {
			c.setSelected(true);
			c.setLessThen(true);
			c.setLessThenValue(val);
		} else {
			System.out.println("ERR");
		}
	}

	public void setCampoGreaterThen(String tab, String campo, Object val) {
		CampoQuery c = cercaCampo(tab, campo);
		if (c != null) {
			c.setSelected(true);
			c.setGreaterThen(true);
			c.setGreaterThenValue(val);
		} else {
			System.out.println("ERR");
		}
	}

	public void setCampoEqualsTo(String tab, String campo, Object val) {
		CampoQuery c = cercaCampo(tab, campo);
		if (c != null) {
			c.setSelected(true);
			c.setEqualTo(true);
			c.setEqualToValue(val);
		} else {
			System.out.println("ERR");
		}
	}

	private CampoQuery cercaCampo(String tab, String campo) {
		for (CampoQuery c : lista)
			if (c.getTabella().equals(tab) && c.getCampo().equals(campo))
				return c;
		return null;
	}

	private void caricaCampi(String tabella, String className) {
		try {
			Field[] ll = Class.forName(className).getDeclaredFields();
			for (Field f : ll) {
				String name = f.getName();
				String type = f.getType().getName();
				if (name.equals("id"))
					continue;
				if (name.equals("n"))
					continue;
				if (type.equals("int") || type.equals("java.lang.String")) {
				
					CampoQuery campo = new CampoQuery(tabella, f);
					addCampo(campo);
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private static final String PERSONAL_DATA = "personal_data";

	private void caricaClassi() {
		caricaCampi("biochemical_data", "beans.BiochemicalData");
		caricaCampi("Hematologic_data", "beans.HematologicData");
		caricaCampi("surgical_intervention", "beans.SurgicalIntervention");
		caricaCampi("personal_data", "beans.PersonalData");

		caricaCampi("genetic_data", "beans.GeneticData");
		caricaCampi("indirect_tests", "beans.IndirectTests");
		caricaCampi("iron_balance", "beans.IronBalance");
	}

	public String buildQuery() {
		String query = "select " + PERSONAL_DATA + ".* FROM ";
		Set<String> tabs = new HashSet<String>();
		tabs.add(PERSONAL_DATA);
		for (CampoQuery c : lista) {
			if (c.isSelected())
				tabs.add(c.getTabella());
		}
		String tabelle = "";
		for (String t : tabs) {
			if (tabelle.length() > 0)
				tabelle += ",";
			tabelle += t;
		}
		if (tabelle.length() == 0)
			tabelle += PERSONAL_DATA;
		query += tabelle;

		String whereCond = "";

		for (CampoQuery c : lista) {
			if (!c.isSelected())
				continue;
			if (c.isEqualTo() || c.isLessThen() || c.isGreaterThen()) {
				if (whereCond.length() > 0)
					whereCond += " AND  ";
				whereCond += " ( ";
			} else
				continue;
			String inner = "";
			if (c.isEqualTo()) {
				if (inner.length() > 0)
					inner += " OR ";
				inner += c.getTabella() + "." + c.getCampo() + " = " + c.getEqualToValue();
			}

			if (c.isLessThen()) {
				if (inner.length() > 0)
					inner += " OR ";
				inner += c.getTabella() + "." + c.getCampo() + " < " + c.getLessThenValue();
			}
			if (c.isGreaterThen()) {
				if (inner.length() > 0)
					inner += " OR ";
				inner += c.getTabella() + "." + c.getCampo() + " > " + c.getGreaterThenValue();
			}
			whereCond += inner + " )";
		}
	//	if (whereCond.length() > 0)
			query += " WHERE ";

		for (String t : tabs) {
			tabelle += t;
			if (whereCond.length() > 0)
				whereCond += " AND ";
			whereCond += t + ".N=" + PERSONAL_DATA + ".N";
		}

		query += whereCond;

		return query;
	}
	public void resetQuery() {
		lista=savedLista;
		
	}
	public String run(Query e) {
		System.out.println("xxxxx");
		System.out.println(e.getXml());
		String xml = e.getXml();
		QueryXmlParser parser = new QueryXmlParser(xml);
		try {
			List<CampoQuery> ll = parser.parse();
			setLista(ll);
			String query = buildQuery();
			System.out.println(query);
			execQuery(e,query);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		return "elenco";
	}

	public void execQuery(Query q, String query) {
		System.out.println(query);
		List<PersonalData> out = new ArrayList<PersonalData>();
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		Connection conn = session.getConnection();
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				PersonalData p = new PersonalData();
				p.setN(rs.getInt("N"));
				p.setSurname(rs.getString("Surname"));
				p.setName(rs.getString("Name"));
				System.out.println(rs.getInt("ID"));

				out.add(p);
			}

			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			DBUtil db = (DBUtil) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext,
					null, "dBUtil");
			db.setCurrentQuery(q);
			db.setCustomPazienti(out);
			JsfUtil.redirect("lista");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
		}
	}

	// public String run(ActionEvent s) {
	// System.out.println("dddddddddddd "+s);
	// return "";
	//
	// }
	private Query selectedQuery;
	private List<CampoQuery> savedLista;

	public static void main(String s[]) {
		QueryHandler q = new QueryHandler();

		q.setCampoEqualsTo("personal_data", "age_at_diagnosis", 2);

		q.setCampoLessThen("biochemical_data", "tot_bilirubin", 2);
		q.setCampoGreaterThen("biochemical_data", "tot_bilirubin", 2);
		q.setCampoGreaterThen("Hematologic_data", "trasf_need", 2);
		q.setCampoGreaterThen("Hematologic_data", "date", "12/12/2001");
		String query = q.buildQuery();
		System.out.println(query);
		try {
			QueryXml qx = new QueryXml();
			String xml = qx.queryToXml(q);

			QueryXmlParser parser = new QueryXmlParser(xml);
			List<CampoQuery> ll = parser.parse();
			q.setLista(ll);
			query = q.buildQuery();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Query getSelectedQuery() {
		return selectedQuery;
	}

	public void setSelectedQuery(Query selectedQuery) {
		this.selectedQuery = selectedQuery;
	}

	public void setLista(List<CampoQuery> lista) {
		if(this.lista!=null)savedLista=this.lista;
		this.lista = lista;
	}

	
}
