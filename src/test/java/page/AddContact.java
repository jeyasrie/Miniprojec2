package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificationMethod;

public class AddContact extends ProjectSpecificationMethod {
	
	@FindBy(id="firstName")
	WebElement firstname;
	
	@FindBy(id="lastName")
	WebElement laststname;
	
	@FindBy(id="birthdate")
	WebElement Birthdate;
	
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(id="phone")
	WebElement Phone;
	
	@FindBy(id="street1")
	WebElement Street1;
	
	@FindBy(id="street2")
	WebElement Street2;
	
	@FindBy(id="city")
	WebElement City;
	
	@FindBy(id="stateProvince")
	WebElement Stateprovince;
	
	@FindBy(id="postalCode")
	WebElement Postalcode;
	
	@FindBy(id="country")
	WebElement Country;
	
	@FindBy(id="submit")
	WebElement Submit;
	
	@FindBy(id="cancel")
	WebElement Cancel;
	
	
	public AddContact(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//pass the value to the field using excel sheet
	public ContactList EnterField(String fname,String lname,String bdate,String emailId,String phoneno,String st1,String st2,String cty,String statepro,String pc,String contry)
	{
		firstname.sendKeys(fname);
		laststname.sendKeys(lname);
		Birthdate.sendKeys(bdate);
		Email.sendKeys(emailId);
		Phone.sendKeys(phoneno);
		Street1.sendKeys(st1);
		Street2.sendKeys(st2);
		City.sendKeys(cty);
		Stateprovince.sendKeys(statepro);
		Postalcode.sendKeys(pc);
		Country.sendKeys(contry);
		Submit.click();
	   return new ContactList(driver);
		}
	
	//validate the fields with positive and negative test case
	
}
