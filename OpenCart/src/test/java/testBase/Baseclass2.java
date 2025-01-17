package testBase;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager; 
import org.apache.logging.log4j.Logger;

public class Baseclass2 {
	public Logger logger;
	protected WebDriver driver; // Change to protected
    protected WebDriverWait mywait; // Change to protected

    @BeforeClass
    public void setup() throws InterruptedException {
    	
        logger=LogManager.getLogger(this.getClass());
    	
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }
}
