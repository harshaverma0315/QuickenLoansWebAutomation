package mortgageCalculatorTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import mortgageCalculatorPageObjects.CalculatorDropdownPage;
import mortgageCalculatorPageObjects.MortgageCalculatorPage;
import resources.base;

public class PurchaseTest extends base {

	@BeforeTest

	public void basePageNavigation() throws IOException {
		driver = invokeDriver();
		driver.get(prop.getProperty("url"));

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\Harsha\\Desktop\\quickenExcel.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheet("mortgage");
		int getTotalRows = sheet.getLastRowNum();
		System.out.println(getTotalRows + " is the totals no. of rows in mortgage sheet");
		int getTotalCol = sheet.getRow(0).getLastCellNum();
		System.out.println(getTotalCol + " is the totals no. of columns in first row");
		Object[][] DataCellValues = new Object[getTotalRows + 1][getTotalCol];
		for (int i = 0; i <= getTotalRows; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j <= getTotalCol - 1; j++) {
				XSSFCell cell = row.getCell(j);
				DataCellValues[i][j] = new DataFormatter().formatCellValue(row.getCell(j));
				System.out.println(DataCellValues[i][j]);
			}
		}
		return DataCellValues;
	}

	@Test
	public void homePage() {
		CalculatorDropdownPage cdp = new CalculatorDropdownPage(driver);

		Actions a = new Actions(driver);
		a.moveToElement(cdp.calDropdown()).build().perform();
		a.moveToElement(cdp.purchase()).click().build().perform();
	}

	@Test(dataProvider = "getData", dependsOnMethods = { "homePage" })
	public void mortgageCalculator(String purchasePrice, String downpayment, String zipCode, String creditScore) {
		MortgageCalculatorPage mcp = new MortgageCalculatorPage(driver);
		mcp.purchasePrice().sendKeys(purchasePrice);
		mcp.downPayment().sendKeys(downpayment);
		mcp.yesButton().click();
		mcp.zipCode().sendKeys(zipCode);
		Select s = new Select(mcp.creditScore());
		s.selectByValue(creditScore);
		
		if(mcp.chatNow().isDisplayed()) {
			Assert.assertTrue(mcp.chatNow().isDisplayed());
		}
		else {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(mcp.popUp())).click();
		}
		
		mcp.submit().click();

	}

	@AfterTest (enabled = false)
	public void teardown() {
		driver.close();
	}

}
