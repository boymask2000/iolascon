package printcreator;

import java.io.InputStream;
import java.util.List;

import beans.BiochemicalData;
import beans.HematologicData;
import beans.PersonalData;
import beans.SurgicalIntervention;
import database.DBUtil;

public class PrintCreatorSchedaPaziente extends PrintCreator {
	public String convertSchedaPazienteToPDF() {

		DBUtil db = getBeanDBUtil();

		PersonalData pers = db.getSelectedPersonalData();

		PrintCreator prt = new PrintCreator();
		prt.insertStartDoc();
		prt.insertPageFormats();

		// ********************************PersonalData
		prt.startPageSequence(null);
		prt.addBlock("Personal Data", "30pt");
		Table t = new Table();
		t.setHeader(false);
		t.addColumnDefinition(new Column("", "6cm"));
		t.addColumnDefinition(new Column("", "4cm"));

		List<Pair> lista = caricaCampi(pers);
		for (Pair p : lista) {
			t.startRow();
			t.addDataCol(p.getName() + ":");
			t.addDataCol("" + p.getVal());
		}

		prt.addtable(t);

		prt.addImage(pers.getPhoto());

		prt.endPageSequence();
		// ********************************Surgical
		prt.startPageSequence(null);
		prt.addBlock("Surgical Intervention", "30pt");
		stampaSurgical(prt, db);
		prt.endPageSequence();
		// ********************************HematologicData
		prt.startPageSequence(PrintCreator.LANDSCAPE);
		prt.addBlock("Hematologic Data", "30pt");
		stampaHematologicData(prt, db);
		prt.endPageSequence();
		// ********************************Biochemical
		prt.startPageSequence(PrintCreator.LANDSCAPE);
		prt.addBlock("Biochemical Data", "30pt");
		stampaBiochemical(prt, db);
		prt.endPageSequence();
		// ********************************IronBalance
		prt.startPageSequence(null);
		prt.addBlock("Iron Balance", "30pt");
		stampaIronBalance(prt, db);
		prt.endPageSequence();
		// ********************************IndirectTests
		prt.startPageSequence(null);
		prt.addBlock("Indirect Tests", "30pt");
		stampaIndirectTests(prt, db);
		prt.endPageSequence();
		// ********************************GeneticData
		prt.startPageSequence(null);
		prt.addBlock("Genetic Data", "30pt");
		stampaGeneticData(prt, db);
		prt.endPageSequence();
		// **********************************************
		prt.insertFineDoc();

		InputStream is = prt.getBufferInputStream();
		try {
			convertToPDFNEW(is);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	private void stampaSurgical(PrintCreator prt, DBUtil db) {

		Table t = new Table();
		t.setHeader(false);
		t.addColumnDefinition(new Column("", "6cm"));
		t.addColumnDefinition(new Column("", "4cm"));

		SurgicalIntervention s = db.getSurgicalIntervention();
		List<Pair> lista = caricaCampi(s);
		for (Pair p : lista) {
			t.startRow();
			t.addDataCol(p.getName() + ":");
			t.addDataCol("" + p.getVal());
		}

		prt.addtable(t);
	}

	private void stampaHematologicData(PrintCreator prt, DBUtil db) {
		List<HematologicData> ll = db.getElencoEmatologic();
		if (ll == null || ll.size() == 0)
			return;
		Table t = new Table();
		t.setFontSize(8);
		t.setHeaderFontSize(8);

		HematologicData hdrs = ll.get(0);
		List<Pair> ttt = caricaCampi(hdrs);
		for (Pair p : ttt) {
			int size = (int) (p.getName().length() * 0.3);
			if (size < 1)
				size = 1;
			if (p.getType().equals("java.util.Date"))
				size = 2;
			if(size>2)size=2;
			t.addColumnDefinition(new Column(p.getName(), size + "cm"));
		}
		for (HematologicData data : ll) {
			t.startRow();
			List<Pair> lista = caricaCampi(data);
			for (Pair p : lista) {

				t.addDataCol("" + p.getVal());
			}

		}
		prt.addtable(t);
	}

	private void stampaBiochemical(PrintCreator prt, DBUtil db) {
		List<BiochemicalData> ll = db.getElencoBiochemicalData();
		if (ll == null || ll.size() == 0)
			return;
		Table t = new Table();
		t.setFontSize(8);
		t.setHeaderFontSize(8);

		BiochemicalData hdrs = ll.get(0);
		List<Pair> ttt = caricaCampi(hdrs);
		for (Pair p : ttt) {
			int size = (int) (p.getName().length() * 0.3);
			if (size < 1)
				size = 1;
			if (p.getType().equals("java.util.Date"))
				size = 2;
			if(size>2)size=2;
			t.addColumnDefinition(new Column(p.getName(), size + "cm"));
		}
		for (BiochemicalData data : ll) {
			t.startRow();
			List<Pair> lista = caricaCampi(data);
			for (Pair p : lista) {

				t.addDataCol("" + p.getVal());
			}

		}
		prt.addtable(t);
	}

	private void stampaIronBalance(PrintCreator prt, DBUtil db) {

	}

	private void stampaIndirectTests(PrintCreator prt, DBUtil db) {

	}

	private void stampaGeneticData(PrintCreator prt, DBUtil db) {
		// TODO Auto-generated method stub

	}
}
