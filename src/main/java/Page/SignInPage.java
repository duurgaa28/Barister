 package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
WebDriver driver;

@FindBy(xpath="//input[@id='email']")
WebElement Your_Email;
@FindBy(xpath="//input[@id='password']")
WebElement Your_Password;
@FindBy(xpath="//input[@id='remember_me']")
WebElement RememberMe_Button;
@FindBy(xpath="//button[@type='submit']")
WebElement Submit_Button;
@FindBy(xpath="//a[@class='tk-password-clr_light']")
WebElement Lost_Password;

public SignInPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
public void inputYourEmail(String email) {
	Your_Email.sendKeys(email);
}
public void inputYourPassword(String password) {
	Your_Password.sendKeys(password);
}
public void clickSubmitButton() {
	Submit_Button.click();
}
}
