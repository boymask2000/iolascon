package printcreator;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.apache.fop.apps.FOPException;

import beans.PersonalData;
import database.DBUtil;
import print.Pair;

public class PrintCreatorSchedaPaziente extends PrintCreator {
	public String convertSchedaPazienteToPDF() {

		DBUtil db = getBeanDBUtil();

		PersonalData pers = db.getSelectedPersonalData();

		PrintCreator prt = new PrintCreator();
		prt.insertStartDoc();
		prt.insertPageFormats();

		prt.startPageSequence(null);
		prt.addBlock("Personal Data", "30pt");
		Table t = new Table();
		t.addColumnDefinition(new Column("", "6cm"));
		t.addColumnDefinition(new Column("", "4cm"));
		
		List<Pair> lista = caricaCampi(pers);
		for( Pair p:lista) {
			t.startRow();
			t.addDataCol(p.getName()+":");
			t.addDataCol(""+p.getVal());
		}

	

		prt.addtable(t);
		
		prt.addImage( pers.getPhoto());
		
		
		prt.endPageSequence();
		
		prt.startPageSequence(null);
		prt.addBlock("Hematologic Data", "30pt");
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
