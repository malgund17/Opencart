package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;

public class TC_002_Login extends BaseClass {
	@Test(groups= {"Sanity","Master"})
	public void test_Login() {
		logger.info("******Starting TC_002_Login ******");
	try {
		HomePage hp = new HomePage(driver);
		hp.clickMyacc();
		hp.clicklogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setpassword(rb.getString("password"));
		lp.clickLogin();
	
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetPage = mp.ismyaccPageExist();
		Assert.assertEquals(targetPage, true);
	}catch(Exception e) {
		Assert.fail();
	}
	logger.info("Finished TC_002_Login");
	
	}
}
