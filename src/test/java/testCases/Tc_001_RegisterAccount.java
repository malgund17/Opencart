package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RegisterPage;
import TestBase.BaseClass;

public class Tc_001_RegisterAccount extends BaseClass {
	@Test(groups= {"Regression","Master"})
	public void test_Account_Registration() {
		logger.debug("Application logs");
		logger.info("***Starting Tc_001_RegisterAccount***");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyacc();
		logger.info("clicked on my account");
		hp.clickRegister();
		logger.info("clicked on Register");
		RegisterPage rp = new RegisterPage(driver);
		rp.setFirstName(randomString().toUpperCase());
		rp.setLastName(randomString().toLowerCase());
		rp.setEmail(randomEmail()+"@gmail.com");
		rp.setTelephone(RandomNum());
		String password = randomEmail();
		rp.setPassword(password);
		rp.setConfirmPassword(password);
		rp.setPrivacyPolicy();
		rp.clickContinue();
		String confirmationmsg = rp.getConfirmationMsg();
		logger.info("validating expected mssg");
		Assert.assertEquals(confirmationmsg,"Your Account Has Been Created!");
		
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("***Finished Tc_001_RegisterAccount***");
}
}