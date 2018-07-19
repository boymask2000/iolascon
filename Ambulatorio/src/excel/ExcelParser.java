package excel;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelParser {
	private InputStream is;
	private int rowNum;
	private Map<String, Object> vals = new HashMap<String, Object>();

	private List<String> names = new ArrayList<String>();
	private String fileName;
	private XSSFWorkbook workbook;

	public ExcelParser(String fileName, InputStream is) {
		this.is = is;
		this.fileName = fileName;
	}

	public void process() {

		workbook = null;
		try {
			workbook = new XSSFWorkbook(is);

			BeanFiller pdFiller = new PersonalDataFiller();
			getName(pdFiller);

			processSheet(workbook, pdFiller);

			int n = pdFiller.getN();

			processGeneticData(n);
			processSurgical(n);
			processOtherInfo(n);

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (workbook != null)
				try {
					workbook.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
		}

	}

	private void processGeneticData(int n) {
		BeanFiller f = new GeneticDataFiller();
		f.setN(n);

		processSheet(workbook, f);
	}

	private void processOtherInfo(int n) {
		BeanFiller other = new OtherInfoFiller();
		other.setN(n);

		processSheet(workbook, other);
	}

	private void processSurgical(int n) {
		BeanFiller surgical = new SurgicalFiller();
		surgical.setN(n);

		processSheet(workbook, surgical);
	}

	private void getName(BeanFiller pdFiller) {
		String v[] = fileName.split(" ");
		pdFiller.setSurname(v[0]);
		pdFiller.setName(v[1]);

	}

	private void processSheet(Workbook workbook, BeanFiller filler) {
		String sName = filler.getSheetName();
		Sheet datatypeSheet = workbook.getSheet(sName);
		if (datatypeSheet == null) {
			System.out.println("Foglio [" + sName + "] non trovato");
			return;
		}
		String name = datatypeSheet.getSheetName();
		System.out.println("Foglio [" + name + "]  trovato");

		Iterator<Row> iterator = datatypeSheet.iterator();

		rowNum = 0;

		while (rowNum < datatypeSheet.getPhysicalNumberOfRows()) {
			rowNum++;
			System.out.println("RoNum = " + rowNum);
			Row currentRow = iterator.next();

			try {
				processRow(currentRow, filler);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	int colCount = 0;

	private void processRow(Row currentRow, BeanFiller filler) {
		Iterator<Cell> cellIterator = currentRow.iterator();
		
		if (currentRow.getRowNum() == 0) {names.clear();colCount = 0;
			while (cellIterator.hasNext()) {

				Cell currentCell = cellIterator.next();

				vals.put(currentCell.getStringCellValue(), "");
				names.add(currentCell.getStringCellValue());
				colCount++;
			}
		} else {
			vals.clear();
			for (int col = 0; col < colCount; col++) {
				String colName = names.get(col);
				// System.out.println(colName);

				Cell currentCell = currentRow.getCell(col);

				String val = getCellValueAsString(currentCell);
				if (colName.equals("ID") && (val == null || val.trim().length() == 0))
					return;
				vals.put(colName, val);
			}
			filler.fillData(vals);
		}

	}

	public static String getCellValueAsString(Cell cell) {
		String strCellValue = null;
		if (cell != null) {
			System.out.println(cell.getCellType());
			System.out.println(cell.toString());
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				strCellValue = cell.toString();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					strCellValue = dateFormat.format(cell.getDateCellValue());
				} else {
					Double value = cell.getNumericCellValue();
					Long longValue = value.longValue();
					strCellValue = new String(longValue.toString());
				}
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				strCellValue = new String(new Boolean(cell.getBooleanCellValue()).toString());
				break;
			case Cell.CELL_TYPE_BLANK:
				strCellValue = "";
				break;
			}
		}
		return strCellValue;
	}
}
