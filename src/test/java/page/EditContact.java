package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;

public class EditContact extends ProjectSpecificationMethod{
	
	
	@FindBy(id="submit")
	WebElement submitBtn;
	
	@FindBy(id="email")
	WebElement edit_id;
	
	@FindBy(id="phone")
	WebElement edit_pno;

	public EditContact(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//edit the  email and phone number
	public ContactDetails editField()
	{
		edit_id.sendKeys("washim@kmail.com");
		edit_pno.sendKeys("324354");
		submitBtn.click();
		return new ContactDetails(driver);
	}
}
