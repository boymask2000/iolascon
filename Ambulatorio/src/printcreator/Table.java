package printcreator;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private StringBuffer buffer = new StringBuffer();
	private List<Column> cols = new ArrayList<Column>();

	private List<List<String>> rows = new ArrayList<List<String>>();

	public Table() {

	}

	public void addColumnDefinition(Column col) {
		cols.add(col);
	}

	private List<String> currentRow = null;
	private boolean hasHeader;
	// private boolean rowStarted = false;

	public void startRow() {

		currentRow = new ArrayList<String>();
		rows.add(currentRow);

		// buffer.append("<fo:table-body>\n" + "<fo:table-row>");
	}

	// public void endRow() {
	// if (!rowStarted)
	// return;
	// rowStarted = false;
	// buffer.append("<fo:table-body>\n" + "<fo:table-row>");
	// }

	public void addDataCol(String val) {
		currentRow.add(val);
		/*
		 * buffer.append(" <fo:table-cell>\n" + "<fo:block>\n"); buffer.append(val);
		 * buffer.append("</fo:block>\n" + "</fo:table-cell>\n");
		 */
	}

	public StringBuffer getBuffer() {
		buffer.append("<fo:table table-layout=\"fixed\" width=\"100%\"");
		buffer.append(" border-collapse=\"separate\">");

		for (Column col : cols) {
			buffer.append("<fo:table-column column-width=\"" + col.getWidth() + "\" />");
		}
		generateHeader();
		buffer.append("<fo:table-body>");
		for (List<String> row : rows) {
			buffer.append("<fo:table-row>");
			for (String ss : row) {
				buffer.append("<fo:table-cell>");
				buffer.append("<fo:block>");
				buffer.append(ss);
				buffer.append("</fo:block>");
				buffer.append("</fo:table-cell>");

			}

			buffer.append("</fo:table-row>");
		}

		buffer.append("</fo:table-body>");
		buffer.append("</fo:table>");
		return buffer;
	}

	private void generateHeader() {
		if( !hasHeader)return;
		buffer.append("<fo:table-header text-align=\"center\"><fo:table-row>");
		for (Column col : cols) {
			buffer.append("<fo:table-cell padding=\"1mm\" border-width=\"1mm\"");
			buffer.append(" border-style=\"solid\">");
			buffer.append("<fo:block>" + col.getName() + "</fo:block>");
			buffer.append("</fo:table-cell>");
		}
		buffer.append("</fo:table-row></fo:table-header>");
	}

	public void setHeader(boolean b) {
		hasHeader=b;
		
	}
}
