package printcreator;

import java.io.InputStream;
import java.util.List;

import beans.PersonalData;
import database.DBUtil;

public class PrintElencoPazienti extends PrintCreator {
	public String convertElencoPazientiToPDF() {

		DBUtil db = getBeanDBUtil();

		PrintCreator prt = new PrintCreator();
		prt.insertStartDoc();
		prt.insertPageFormats();

		prt.startPageSequence(null);
		prt.addBlock("Selection: "+db.getCurrentSelectionDesc(), "30pt");
		Table t = new Table();
		t.addColumnDefinition(new Column("", "6cm"));
		t.addColumnDefinition(new Column("", "4cm"));
		
		List<PersonalData> lista = db.getPazienti();
		
		for( PersonalData p:lista) {
			t.startRow();
			t.addDataCol(p.getSurname());
			t.addDataCol(p.getName());
		}

		prt.addtable(t);
		prt.endPageSequence();
		prt.insertFineDoc();

		InputStream is = prt.getBufferInputStream();
		try {
			convertToPDFNEW(is);
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return "";
	}
}
