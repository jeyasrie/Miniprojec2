package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.ContactDetails;
import page.ContactList;
import page.HomePage;

public class TC_006DeleteContact  extends ProjectSpecificationMethod {
	@BeforeTest
	public void setup()
	{
		sheetname="delete";
		testName=" delete contact  listTest";
		testDescription="Testing the fields can delete";
		testAuthor="Jeyasri";
		testCategory="Smoke Testing";
	}

	@Test(dataProvider="readdata")
	public void Contact(String FName,String LName,String dob,String EID,String pno,String SA1,String SA2,String CITY,String STate,String poscode,String COUNTRY) throws Exception
	{
	 
	 HomePage log=new HomePage(driver);
	   log.Login("anvika@kmail.com","anvika123");
	   
	   
	    ContactList cl=new ContactList(driver);
	    cl  .ClickAddnewuser()
	  .EnterField(FName, LName, dob, EID, pno, SA1, SA2, CITY, STate, poscode,COUNTRY);
	  
	   
	     cl.Clickrow();
	    ContactDetails cd=new ContactDetails(driver);
	    cd.DeleteContact();
	    cl.Clicklogout();
	    
	}
}


