package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.DriveIntiation;
import Page.HomePage;
import Util.PropertyRead;
import Util.RetryAnalyzer;
import Util.ScreenShotClass;

@Listeners(Util.ReportUtil.class)
public class SearchTest extends DriveIntiation {

	HomePage homePage;

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void asearchTest() throws Exception {
		homePage = new HomePage(driver);
		String legal_Service = PropertyRead.getProperty("Enter_LegalService", "Not found");
		homePage.searchLegalService(legal_Service);
		String category = PropertyRead.getProperty("Enter_Category", "Not found");
		homePage.selectCategory(category);
		homePage.clickSearchButton();
		 ScreenShotClass.takeScreenshot("Search.png", driver);
	}
}