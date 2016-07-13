package pe.com.dev.test;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ManageXLS {

	public static void main(String[] args) {
		
	}
	public void readXLSX(){
		try {
			FileInputStream file = new FileInputStream(new File("c:/opt/Book1.xlsx"));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// Check the cell type and format accordingly
					switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(cell)) {
								SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
								System.out.println(sdf.format(cell.getDateCellValue()) + " t ");
							}else {
								System.out.print(cell.getNumericCellValue() + " t ");
							}
							break;
						case Cell.CELL_TYPE_STRING:
							System.out.print(cell.getStringCellValue() + " t ");
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							System.out.print(cell.getBooleanCellValue() + " t ");
							break;
						case Cell.CELL_TYPE_FORMULA:
							System.out.print(cell.getNumericCellValue() + " t ");
							break;
						case Cell.CELL_TYPE_ERROR:
							System.out.print(cell.getErrorCellValue() + " tx ");
							break;
					}
				}
				System.out.println("");
			}
			workbook.close();
			file.close();

		} catch (Exception e) {
			e.getMessage();
		}

	}

}
