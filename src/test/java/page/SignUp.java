package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class SignUp extends ProjectSpecificationMethod {
	
	@FindBy(id="firstName")
	WebElement firstname;
	
	@FindBy(id="lastName")
	WebElement lastname;
	
	@FindBy(id="email")
	WebElement emailID;
	
	@FindBy(id="password")
	WebElement Password ;
	@FindBy(id="submit")
	WebElement submitbutton;
	
	public SignUp(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public SignUp enterFirstName(String Firstname) {
	firstname.sendKeys(Firstname);
	return this;
	}
	public SignUp enterLastName(String Lastname) {
		lastname.sendKeys(Lastname);
		return this;
		}
	public SignUp enterMail(String Email) {
		emailID.sendKeys(Email);
		return this;
		}
	public SignUp enterPasswd(String Pass) {
		Password.sendKeys(Pass);
		return this;
		}
	public ContactList ClickSubmit()
	{
		submitbutton.click();
		return new ContactList(driver);
	}
}
