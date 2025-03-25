package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.ProjectSpecificationMethod;

public class HomePage extends ProjectSpecificationMethod {
	
	@FindBy(id="signup")
	WebElement signupbutton;
	
	@FindBy(id="email")
	WebElement userEmail;
	
	@FindBy(id="password")
	WebElement Password;
	

	@FindBy(id="submit")
	WebElement submitbutton;
    

	@FindBy(xpath="//header/h1")
	WebElement validpage;
	
	@FindBy(id="error")
	WebElement invalidLogin;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public SignUp Clicksignup()
	{
		signupbutton.click();
		return new SignUp(driver);
	}
	
	public ContactList Login(String emailID,String pwd)
	{
		userEmail.sendKeys(emailID);
		Password.sendKeys(pwd);
		submitbutton.click();
		return new ContactList(driver);
	}
	
	public HomePage validateLogin(String Testtype,String expected) throws InterruptedException
	{
		if (Testtype.equalsIgnoreCase("Valid email and valid password"))
		{
			String actualText=validpage.getText();
			Assert.assertEquals(actualText, expected);
		}
		else if(Testtype.equalsIgnoreCase("negative"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(invalidLogin));
			String actualText=invalidLogin.getText();
			SoftAssert SAObj=new SoftAssert();
			SAObj.assertEquals(actualText, expected);
		    SAObj.assertAll();
		}
		
		return this;
	}
}
