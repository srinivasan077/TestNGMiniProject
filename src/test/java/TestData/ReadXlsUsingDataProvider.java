package TestData;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.page.objects.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadXlsUsingDataProvider {
	public static WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HP\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1,dataProvider = "testExceldata" )
	public void aloginPage(String username ,String password) throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.enterNameandPassword(username, password);

		Thread.sleep(10000);
	}
//Hard coding method
	@DataProvider(name = "testData")
	public Object[][] provideTestData() {
		return new Object[][] { { "srini@gmail.com", "password1" }, { "vasan@gmail.com", "password2" },
				{ "krish@gmail.com", "password3" }, };
	}
//Data-driven method
	@DataProvider(name = "testExceldata")
	public Object[][] provideTestExcelData() {
		Object[][] data = null;
		try {
			FileInputStream s = new FileInputStream(
					"C:\\Users\\HP\\eclipse-workspace\\TestMaven\\src\\main\\resources\\Test\\Data\\EmpData.xlsx");

			Workbook workbook = new XSSFWorkbook(s);

			Sheet sheet1 = workbook.getSheetAt(0);
			int rowcount = sheet1.getLastRowNum() - sheet1.getFirstRowNum() + 1;
			int columnCount = sheet1.getRow(0).getLastCellNum();
			data = new Object[rowcount - 1][columnCount];

			for (int i = 1; i < rowcount; i++) {

				for (int j = 0; j < columnCount; j++) {
					data[i - 1][j] = sheet1.getRow(i).getCell(j).getStringCellValue();
				}

			}
			workbook.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return data;
	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
}
