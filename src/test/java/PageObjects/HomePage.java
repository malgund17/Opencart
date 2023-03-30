package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Basepage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	//elements
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myAcc;
	
	@FindBy (linkText="Register")
	WebElement register;
	
	@FindBy(xpath="(//a[normalize-space()='Login'])[1]")
	WebElement login;
	
	public void clickMyacc() {
		myAcc.click();
	}
	public void clickRegister() {
		register.click();
	}
	public void clicklogin() {
		login.click();
	}

}
