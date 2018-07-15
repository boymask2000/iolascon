package printcreator;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.transform.TransformerException;

import org.apache.fop.apps.FOPException;

import beans.PersonalData;
import database.DBUtil;

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
		t.addColumnDefinition(new Column("", "2cm"));
		t.addColumnDefinition(new Column("", "2cm"));

		t.startRow();
		t.addDataCol("First Name:");
		t.addDataCol(pers.getName());

		prt.addtable(t);
		prt.endPageSequence();
		prt.insertFineDoc();

		InputStream is = prt.getBufferInputStream();
		try {
			convertToPDFNEW(is);
		} catch (FOPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}
}
