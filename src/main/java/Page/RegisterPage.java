package Page;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.ScreenShotClass;
import Util.WaitUtil;

public class RegisterPage {
	WebDriver driver;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement First_Name;
	@FindBy(xpath = "//input[@id='last_name']")
	WebElement Last_Name;
	@FindBy(xpath = "//input[@id='email']")
	WebElement Email;
	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;
	@FindBy(xpath = "//input[@id='password_confirmation']")
	WebElement Confirm_Password;
	@FindBy(xpath = "//input[@id='buyer']")
	WebElement Client;
	@FindBy(xpath = "//input[@id='seller']")
	WebElement Advocate;
	@FindBy(xpath = "//input[@id='user_terms_agree']")
	WebElement Terms_Conditions;
	@FindBy(xpath = "//button[@class='tk-btn-solid-lg']")
	WebElement Register_Button;
	@FindBy(xpath="//div[@class='tk-loginalert_error']//li[text()='The password must be at least 8 characters.']")
	WebElement Validation_Message;
	@FindBy(xpath="//div[@class='tk-loginalert_error']//li[text()='The email has already been taken.']")
	WebElement Exist_Message;
	@FindBy(xpath="//a[text()='Sign in today']")
	WebElement SignIn_Button;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void inputFirstName(String firstName) {
		First_Name.sendKeys(firstName);
	}

	public void inputLastName(String lastName) {
		Last_Name.sendKeys(lastName);
	}

	public void inputEmail(String email) {
		Email.sendKeys(email);
	}

	public void inputPassword(String password) {
		Password.sendKeys(password);
	}

	public void inputConfirmPassword(String confirmPassword) {
		Confirm_Password.sendKeys(confirmPassword);
	}

	public void selectRadioButton(String userType) {
		if (userType.equalsIgnoreCase("client")) {
			Client.click();
		} else if (userType.equalsIgnoreCase("advocate")) {
			Advocate.click();
		} else {
			throw new IllegalArgumentException("Invalid user type: " + userType);
		}
	}

	public void clickTermsAndConditions() {
		Terms_Conditions.click();
	}

	public void clickRegisterButton() throws Exception {
		Register_Button.click();
	}
	public String passwordValidation() {
		 return Validation_Message.getText();
	}
	public String existEmailValidation() {
		return Exist_Message.getText();
	}
    public void clickSignIn() {
    	WaitUtil wait = new WaitUtil(driver); 
    	wait.explicitWait(10, SignIn_Button);
    	JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    	javascriptExecutor.executeScript("window.scrollBy(560, 715)");
    	  try {
    	        SignIn_Button.click();
    	    } catch (ElementClickInterceptedException e) {
    	    	 javascriptExecutor.executeScript("arguments[0].click();", SignIn_Button);
    	    	 System.out.println("Not able to click Sign In button");
    	    }
    

}
}
