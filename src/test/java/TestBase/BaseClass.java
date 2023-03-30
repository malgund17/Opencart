package TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
public static WebDriver driver;
public Logger logger;

public ResourceBundle rb;

@BeforeClass(groups= {"Master","Sanity","Regression"})
@Parameters("browser")
public void Setup(String br) {
	rb = ResourceBundle.getBundle("config");
	
	logger= LogManager.getLogger(this.getClass());
	
	ChromeOptions object = new ChromeOptions();
	object.addArguments("--remote-allow-origins=*");
	
	if(br.equals("chrome")) {
	driver=new ChromeDriver(object);}
	else if(br.equals("edge")) {
		driver=new EdgeDriver();}
	
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(rb.getString("appURL"));
	driver.manage().window().maximize();
}
@AfterClass(groups= {"Master","Sanity","Regression"})
public void tearDown() {
	driver.quit();
}

public String randomString() {
	String randomName = RandomStringUtils.randomAlphabetic(10);
	return randomName;
}
public String RandomNum() {
	String randomNum = RandomStringUtils.randomNumeric(10);
	return randomNum;
}
public String randomEmail() {
	String st = RandomStringUtils.randomAlphanumeric(5);
	return st;
	
}
public String captureScreen(String tname) throws IOException {
	String timestamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
	File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    String destination = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
	File d = new File(destination);
    try {
	FileUtils.copyFile(s, d);}
    catch(Exception e) {
    	e.getMessage();
    }
    return destination;
	
}

}
