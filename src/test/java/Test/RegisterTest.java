package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.DriveIntiation;
import Page.HomePage;
import Page.RegisterPage;
import Util.RetryAnalyzer;
import Util.ScreenShotClass;
import Util.ExcelReadUtil;
import Util.PropertyRead;

@Listeners(Util.ReportUtil.class)

public class RegisterTest extends DriveIntiation {
	HomePage homePage;
	RegisterPage registerPage;

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void registerTest() throws Exception {
		homePage = new HomePage(driver);
		homePage.clickLegalHelpButton();
		registerPage = new RegisterPage(driver);
		String First_Name = PropertyRead.getProperty("Enter_FirstName", "Not found");
		registerPage.inputFirstName(First_Name);

		String Last_Name = PropertyRead.getProperty("Enter_LastName", "Not found");
		registerPage.inputLastName(Last_Name);

		String Email = PropertyRead.getProperty("Enter_Email", "Not found");
		registerPage.inputEmail(Email);
		String Password = PropertyRead.getProperty("Enter_Password", "Not found");
		registerPage.inputPassword(Password);
		String Confirm_Password = PropertyRead.getProperty("ConfirmYour_Password","Not found");
		registerPage.inputConfirmPassword(Confirm_Password);
		registerPage.selectRadioButton("Client");
		registerPage.clickTermsAndConditions();
		registerPage.clickRegisterButton();
		ScreenShotClass.takeScreenshot("Registration.png", driver);
	

	}

	/*
	 * //@DataProvider(name = "NewUser") //public Object[][] getUserDetails() throws
	 * IOException { //List<String[]> infoList = new ArrayList<String[]>();
	 * ExcelReadUtil excelReads = new ExcelReadUtil(); String First_Name =
	 * excelReads.readExcelData(1, 1); String Last_Name =
	 * excelReads.readExcelData(2, 1); String Email = excelReads.readExcelData(3,
	 * 1); String Password = excelReads.readExcelData(4, 1); String Confirm_Password
	 * = excelReads.readExcelData(5, 1); infoList.add(new String[] { First_Name,
	 * Last_Name, Email, Password, Confirm_Password }); return infoList.toArray(new
	 * String[infoList.size()][]); }
	 */
}
