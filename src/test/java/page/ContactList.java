package page;

import java.time.Duration;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificationMethod;

public class ContactList extends ProjectSpecificationMethod{
    
	
	@FindBy(id="add-contact")
	WebElement addNewUser;
	

	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> name;
	
	
	
	@FindBy(xpath="//tr[1]/td[2]")
	WebElement clickrow;
	
	@FindBy(id="logout")
	WebElement Logoutbtn;
	
	@FindBy(id="error")
	WebElement invalid;
	
	
	
	@FindBy(xpath="//p[text()='Click on any contact to view the Contact Details']")
	WebElement valid;
	
	
	//constructor chaining
	public ContactList(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//click add new user
	public AddContact ClickAddnewuser()
	{
		addNewUser.click();
		return new AddContact(driver);
	}
public ContactList validateuserField(String testtype,String Expected)
	
	{
		if(testtype.equalsIgnoreCase("positive"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(valid));
		String	actualText=valid.getText();
		Assert.assertEquals(actualText, Expected);
		System.out.println(Expected);
		
		}
		else if(testtype.equalsIgnoreCase("negative"))
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(invalid));
		String	actualText=invalid.getText();
		Assert.assertEquals(actualText, Expected);
		System.out.println(Expected);
		}
		return this;
		
	}
	

	 
//	sort the last name by asecending order
 public ContactList Asec_lastname()
 {
	name.sort(Comparator.comparing(element ->{
		String fullName = element.getText();          // Get the text content of the WebElement (fname lname)

	 // Split the name into fname and lname, and return the last name for sorting
		String lname = fullName.split(" ")[1];   // Assuming the name is in "fname lname" format
		 return lname;  // Return the last name for sorting
	}));
	 for (WebElement element : name) {
         System.out.println(element.getText());  // Prints the full name (fname lname)
     }
	 
	 return this;
	 
	 
 }
 
 //select the row for editing
 public ContactDetails Clickrow()
 {
	 clickrow .click();
	 return new ContactDetails(driver);
 }
 //select row  for deleting


 //logout function
 public HomePage Clicklogout()
 {
	 Logoutbtn.click();
	 return new HomePage(driver);
 }
}

