package Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.DriveIntiation;
import Page.HomePage;
import Page.RegisterPage;
import Page.SignInPage;
import Util.PropertyRead;
import Util.RetryAnalyzer;
import Util.ScreenShotClass;

@Listeners(Util.ReportUtil.class)

public class SignInTest extends DriveIntiation {
	HomePage homePage;
	RegisterPage registerPage;
	SignInPage signInPage;

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void signInTest() throws Exception {
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
		String Confirm_Password = PropertyRead.getProperty("ConfirmYour_Password", "Not found");
		registerPage.inputConfirmPassword(Confirm_Password);
		registerPage.selectRadioButton("Client");
		registerPage.clickTermsAndConditions();
		registerPage.clickRegisterButton();

		try { // Check if the validation message for existing email is correct
			Assert.assertEquals(registerPage.existEmailValidation(), "The email has already been taken.");
			// If assertion is true, click the sign-in button
			registerPage.clickSignIn();
		} catch (AssertionError e) { // Re-throw the assertion error if it's a different message throw e;
		}
		signInPage = new SignInPage(driver);

		signInPage.inputYourEmail(Email);
		signInPage.inputYourPassword(Password);
		signInPage.clickSubmitButton();

		ScreenShotClass.takeScreenshot("SignInPage.png", driver);
	}

}
