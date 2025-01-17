package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

// in the base class whatever the method which we use repetative so we keep them in this class
public class BaseClass {
 WebDriver driver;
  WebDriverWait mywait;
	@BeforeClass
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://tutorialsninja.com/demo/");
	//	Thread.sleep(Duration.ofSeconds(8));
		//driver.navigate().refresh();

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber() {
		String generatedNum = RandomStringUtils.random(10);
		return generatedNum;
	}

	
	
	
	
	
	
	
}








