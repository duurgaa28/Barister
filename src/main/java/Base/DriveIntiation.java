package Base;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class DriveIntiation {

    public static final String INITIAL_URL = "https://barrister.a3i.in";
    public WebDriver driver;

    @BeforeTest
    @Parameters({ "browser" })
    public void setUp(@Optional("chrome") String browser) throws Exception {
        driver = driveInitialize(browser);
        driver.get(INITIAL_URL);
    }

    public WebDriver driveInitialize(String browserName) throws Exception {
        WebDriver driver;


if (browserName.equalsIgnoreCase("firefox")) {
	 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver.exe");
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	} 
	else if (browserName.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize(); 
	} 
	else {
		throw new Exception("Incorrect Browser");
	}
return driver;
}
    @AfterTest
	public void closeTest() {
		driver.quit();
	}
	 
}

