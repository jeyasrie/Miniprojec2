package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class ContactDetails extends ProjectSpecificationMethod  {
	
	@FindBy(id="edit-contact")
	WebElement Edit;
	
	@FindBy(id="delete")
	WebElement Delete;
	
	@FindBy(id="return")
	WebElement Return;
	
	
	
	
	//constructor chaining
	public ContactDetails(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//click edit button  thirdrow
	public EditContact ClickEdit()
	{
		Edit.click();
		
		return new EditContact(driver);
	}
	//click return to contact
	public ContactList ReturntoContact()
	{
		Return.click();
		return new ContactList(driver);
	}
	//delete the single contact
 public ContactList DeleteContact()
 {
	
	 Delete.click();
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		 driver.switchTo().alert().accept();
		 return new ContactList(driver);
		}
}
