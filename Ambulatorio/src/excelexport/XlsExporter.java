package excelexport;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import beans.JsfUtil;
import beans.PersonalData;
import common.AmbUtils;
import common.Pair;
import common.TempFileFactory;
import database.DBUtil;

public class XlsExporter {
	public void export() throws Exception {
		System.out.println("export");
		File out = TempFileFactory.getTempFile(".xls");
		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet_personal_data = workbook.createSheet("Personal data");
		XSSFSheet sheet_surgical = workbook.createSheet("Surgical intervention");
		XSSFSheet sheet_hematologic = workbook.createSheet("Hematologic data");
		XSSFSheet sheet_biochemical = workbook.createSheet("Biochemical data");
		XSSFSheet sheet_iron = workbook.createSheet("Iron balance");
		XSSFSheet sheet_indirect = workbook.createSheet("Indirect tests");
		XSSFSheet sheet_genetic = workbook.createSheet("Genetic data");
		XSSFSheet sheet_other = workbook.createSheet("Other info");

		DBUtil db = (DBUtil) JsfUtil.getBean("dBUtil");
		List<PersonalData> lista = db.getPazienti();

		for (PersonalData d : lista) {
			writeBean(sheet_personal_data, d);
		}

		FileOutputStream outputStream = new FileOutputStream(out);
		workbook.write(outputStream);
		workbook.close();

		System.out.println(out.getAbsolutePath());
	}

	private void writeBean(XSSFSheet sheet, Object d) {
		List<Pair> campi = AmbUtils.caricaCampi(d,true);

		int numRows = sheet.getPhysicalNumberOfRows();

		
		if (numRows == 0) {
			Row row = sheet.createRow(numRows++);
			int colNum = 0;
			for (Pair p : campi) {
				Cell cell = row.createCell(colNum++);
				cell.setCellValue(p.getName());
			}
		}
		Row row = sheet.createRow(numRows++);
		int colNum = 0;
		for (Pair p : campi) {
			String type=p.getType();
			Cell cell = row.createCell(colNum++);
			
			try {
				cell.setCellType(CellType.STRING);
				cell.setCellValue(""+ p.getVal());
			} catch (Throwable e) {
				
				e.printStackTrace();
			}
			
//			if (type.equals("int")) {
//				cell.setCellType(CellType.NUMERIC);
//				cell.setCellValue(Integer.parseInt((String) p.getVal()));
//			}
//			if (type.equals("java.lang.String")) {
//				cell.setCellType(CellType.STRING);
//				cell.setCellValue((String) p.getVal());
//			}
//			if (type.equals("java.util.Date")) {
//				cell.setCellType(CellType.STRING);
//				cell.setCellValue((String) p.getVal());
//			}
			
		}
	}

}
