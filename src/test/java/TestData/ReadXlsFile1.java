package TestData;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXlsFile1 {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\HP\\eclipse-workspace\\TestMaven\\src\\main\\resources\\Test\\Data\\EmpData.xlsx");

			Workbook workbook = new XSSFWorkbook(fis);

			Sheet sheet1 = workbook.getSheetAt(0);
			// Count rows and columns
			int rowcount = sheet1.getLastRowNum() - sheet1.getFirstRowNum() + 1;
			int columnCount = sheet1.getRow(0).getLastCellNum();

			// Below is for each concept
			for (Row row : sheet1) {

				for (Cell cell : row) {

					String data = cell.getStringCellValue();
					System.out.print(data + " ");
				}
				System.out.println();
			}

			// Below is for loop concept
			for (int i = 0; i < rowcount; i++) {

				for (int j = 0; j < columnCount; j++) {

					String data = sheet1.getRow(i).getCell(j).getStringCellValue();
					System.out.print(data + " ");
				}
				System.out.println();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
