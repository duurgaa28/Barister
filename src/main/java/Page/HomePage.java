package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath = "//a[text()='Home']")
	WebElement homeButton;

	@FindBy(xpath = "//a[text()='About us']")
	WebElement aboutUsButton;

	@FindBy(xpath = "//a[@class='tk-btn-solid-sm tk-registerbtn']")
	WebElement registerButton;

	@FindBy(xpath = "//a[@class='tk-btn-solid-sm tk-btn-yellow']")
	WebElement signUpButton;

	@FindBy(xpath = "//i[@class='icon-briefcase']")
	WebElement solicitorButton;

	@FindBy(xpath = "//li[@class='tk-linestyle']/preceding::a[@class='tk-btn-solid-white']")
	WebElement legalHelpButton;

	@FindBy(xpath = "//input[@id='search_keyword']")
	WebElement legalServiceSearch;

	@FindBy(xpath = "//select[@id='tk_category_opt']")
	WebElement categorySelect;

	@FindBy(xpath = "//div[@class='tk-searchbtn']")
	WebElement searchButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickHomeButton() {
		homeButton.click();
	}

	public void clickRegisterButton() {
		registerButton.click();
	}

	public void clickSignUpButton() {
		signUpButton.click();
	}

	public void clickSolicitorButton() {
		solicitorButton.click();
	}

	public void clickLegalHelpButton() {
		legalHelpButton.click();
	}

	public void searchLegalService(String legalServices) {
		legalServiceSearch.sendKeys(legalServices);
	}

	public void selectCategory(String category) {
		Select dropdown = new Select(categorySelect);
		dropdown.selectByVisibleText(category);
	}

	public void clickSearchButton() {
		searchButton.click();
	}
}
