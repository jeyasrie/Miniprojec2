package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.ContactDetails;
import page.ContactList;
import page.HomePage;

public class TC_005EditContact  extends ProjectSpecificationMethod {
	@BeforeTest
	public void setup()
	{
		sheetname="editcontact";
		testName=" Edit contact  listTest";
		testDescription="Testing the fields can edit";
		testAuthor="Jeyasri";
		testCategory="Smoke Testing";
	}

	@Test(dataProvider="readdata")
	public void EditContact(String FName,String LName,String dob,String EID,String pno,String SA1,String SA2,String CITY,String STate,String poscode,String COUNTRY) throws Exception
	{
	 
	 HomePage log=new HomePage(driver);
	   log.Login("sankar@kmail.com","sankar123");
	   
	   
	    ContactList cl=new ContactList(driver);
	    cl  .ClickAddnewuser()
	  .EnterField(FName, LName, dob, EID, pno, SA1, SA2, CITY, STate, poscode,COUNTRY);
	  
	   
	   cl.Clickrow();
	    ContactDetails cd=new ContactDetails(driver);
	    cd.ClickEdit()
	    .editField()
	    .ReturntoContact();
	   
	    
	}
}



