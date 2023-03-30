package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Basepage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
@FindBy(xpath="//input[@id='input-email']")
WebElement email;

@FindBy(xpath="//input[@id='input-password']")
WebElement password;

@FindBy(xpath="//input[@value='Login']")
WebElement buttnLogin;

public void setEmail(String emailid) {
	email.sendKeys(emailid);
}
public void setpassword(String pwd) {
	password.sendKeys(pwd);
}
public void clickLogin() {
	buttnLogin.click();
}
}
