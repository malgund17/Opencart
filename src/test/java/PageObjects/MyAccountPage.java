package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Basepage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
@FindBy(xpath="//h2[normalize-space()='My Account']")
WebElement myaccount;
@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
WebElement logout;

public boolean ismyaccPageExist() {
	try {
	return myaccount.isDisplayed();
}catch(Exception e) {
	return(false);
}
}
public void clicklogout() {
	logout.click();
}
}


