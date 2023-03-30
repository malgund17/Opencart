package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;
import Utilities.DataProviders;

public class TC_003_loginDDT extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email,String Password,String expResult) {
		try {
		logger.info("**** Starting TC_003_loginDDT ****");
		HomePage hp = new HomePage(driver);
		hp.clickMyacc();
		hp.clicklogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setpassword(Password);
		lp.clickLogin();
		
		MyAccountPage mp= new MyAccountPage(driver);
		boolean targetPage=mp.ismyaccPageExist();
		if(expResult.equals("valid")) {
		if(targetPage==true) {
		mp.clicklogout();
		Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		}
		if(expResult.equals("invalid")) {
			if(targetPage==true) {
			mp.clicklogout();
			Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
			}
		}catch(Exception e) {
			Assert.fail();
		}
	
		}
}



