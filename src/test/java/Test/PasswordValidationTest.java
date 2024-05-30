package Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.DriveIntiation;
import Page.HomePage;
import Page.RegisterPage;
import Util.PropertyRead;
import Util.RetryAnalyzer;
import Util.ScreenShotClass;


	@Listeners(Util.ReportUtil.class)

	public class PasswordValidationTest  extends DriveIntiation {
		HomePage homePage;
		RegisterPage registerPage;

		@Test(retryAnalyzer = RetryAnalyzer.class)
		public void passwordValidationChecck() throws Exception {
			homePage = new HomePage(driver);
			homePage = new HomePage(driver);
			homePage.clickLegalHelpButton();
			registerPage = new RegisterPage(driver);
			String First_Name = PropertyRead.getProperty("Enter_FirstName", "Not found");
			registerPage.inputFirstName(First_Name);

			String Last_Name = PropertyRead.getProperty("Enter_LastName", "Not found");
			registerPage.inputLastName(Last_Name);

			String Email = PropertyRead.getProperty("Invalid_Email", "Not found");
			registerPage.inputEmail(Email);
			String Password = PropertyRead.getProperty("Invalid_Password", "Not found");
			registerPage.inputPassword(Password);
			String Confirm_Password = PropertyRead.getProperty("Invalid_ConfirmPassword", "Not found");
			registerPage.inputConfirmPassword(Confirm_Password);
			registerPage.selectRadioButton("Client");
			registerPage.clickTermsAndConditions();
			registerPage.clickRegisterButton();
			Assert.assertEquals(registerPage.passwordValidation(), "The password must be at least 8 characters.");
			ScreenShotClass.takeScreenshot("PasswordValidation.png", driver);
}
	}
