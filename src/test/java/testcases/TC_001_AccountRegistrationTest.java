package testcases;



import org.testng.Assert;



import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.bin.AccountRegistrationPage;
import testBase.BaseClass;   //this is why bcoz we extends-mns import from different package.. baseclass is from testbase..
public class TC_001_AccountRegistrationTest extends BaseClass{

	@Test
	public void test_account_Registration()
	{
		try
		{
			
			
		// [ 1] creating object for Homepage class for invoking Methods from Homepage class
			
		logger.info("Stating message TC_oo1 AccountRegistrationTest");
		logger.debug("**********generating the debug logs*******");   // one logg message is enough for debug logs..
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		logger.info(" Clicked on Registration link");
		
		
		
		
		// [2] creating object for AccountRegistrationPage for invoking Methods from AccountRegistrationPage Class
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		// Here passing RandomValues into the Methods
		
		logger.info("Providing customer detatils");
		regpage.setFirstName(randomeString().toUpperCase());  // passed random generated string firstname
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String passwor=randomAlphaNumeric();
		regpage.setPassword(passwor);
		regpage.setConfirmPassword(passwor);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		// Here We are doing Validations in TestCase
		
		String confmsg=regpage.getConfirmationMsg();
		
		 // TO write logger messages we need to use """"if condition , i  if condition only we will write logger messages.....
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("test passed");
			Assert.assertTrue(true);
		}
		else 
		{
			logger.info("test failed");
			Assert.assertTrue(false);
		}
		
		// Assert.assertEquals(confmsg, "Your Account Has Been Created!");  //Assertions (validations)....by our script is called automation testing.
		     // above statement validation. if it equal it will pass,, if it is not equal it will faill
		 // TO write logger messages we need to use """"if condition , i  if condition only we will write logger messages.....
		 
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
		
	
}
