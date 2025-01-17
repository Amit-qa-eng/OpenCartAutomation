package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class AccountRegistrationTest {
	WebDriver driver;
	WebDriverWait mywait;

	
	@BeforeClass
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
		mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	
	
	
	@Test
	public void verify_account_registration() throws InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		Thread.sleep(Duration.ofSeconds(2));
         hp.clickRegister();

		AccountRegistrationPage rp = new AccountRegistrationPage(driver);
		rp.setFirstName(randomString().toLowerCase());// random generated string name
		Thread.sleep(Duration.ofSeconds(2));
		rp.setLastName(randomString().toLowerCase());//random generated stringName
		Thread.sleep(Duration.ofSeconds(2));
		rp.setEmail(randomString()+"@gmail.com");// randomly generated email
		Thread.sleep(Duration.ofSeconds(2));
		rp.setTelephone("99001523727");
		Thread.sleep(Duration.ofSeconds(2));
		rp.setPassword("12345abc");
		Thread.sleep(Duration.ofSeconds(2));
		rp.setConfirmPassword("12345abc");
		Thread.sleep(Duration.ofSeconds(2));
		rp.setPrivacyPolicy();
		Thread.sleep(Duration.ofSeconds(2));
		rp.clickContinue();
        String confirmsg = rp.getConfirmationMsg();
        Assert.assertEquals(confirmsg, "Your Account Has Been Created!");
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
