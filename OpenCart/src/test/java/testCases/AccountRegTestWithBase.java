package testCases;




import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.Baseclass2;

public class AccountRegTestWithBase extends Baseclass2 {

	  @Test
	    public void verify_account_registration() throws InterruptedException {
		  
		    logger.info("*********Starting AccountRegister***********");
		    try {
	        HomePage hp = new HomePage(driver);
	        hp.clickMyAccount();
	        logger.info("*********click on myaccount***********");
	        mywait.until(ExpectedConditions.elementToBeClickable(hp.lnkRegister)); // Use explicit wait
	        logger.info("*********click on resiter ***********");
	        hp.clickRegister();

	        AccountRegistrationPage rp = new AccountRegistrationPage(driver);
	        logger.info("*********providing customer details ***********");
	        rp.setFirstName(randomString().toLowerCase()); // random generated string name
	        rp.setLastName(randomString().toUpperCase()); // random generated stringName
	        rp.setEmail(randomString() + "@gmail.com"); // randomly generated email
	        rp.setTelephone("99001523727");
	        rp.setPassword("12345abc");
	        rp.setConfirmPassword("12345abc");
	        rp.setPrivacyPolicy();
	        rp.clickContinue();
	        logger.info("*********validating expected message  ***********");
	        String confirmsg = rp.getConfirmationMsg();
	        Assert.assertEquals(confirmsg, "Your Account Has Been Created!");
		    }
		    catch(Exception e) {
		    	logger.error("*****test failed*******");
		    	logger.debug("debug logs.....");
		    	Assert.fail();
		    }
		    logger.info("*******test finisehed*********");
	    }
	
}
