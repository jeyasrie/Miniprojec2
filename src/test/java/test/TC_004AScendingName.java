package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.AddContact;
import page.ContactDetails;
import page.ContactList;
import page.HomePage;

public class TC_004AScendingName extends ProjectSpecificationMethod {
	@BeforeTest
	public void setup()
	{
		sheetname="contact";
		testName="contact  listTest";
		testDescription="Testing  name field lastname is ascending order";
		testAuthor="Jeyasri";
		testCategory="Smoke Testing";
	}

	@Test(dataProvider="readdata")
	public void Contact(String FName,String LName,String dob,String EID,String pno,String SA1,String SA2,String CITY,String STate,String poscode,String COUNTRY) throws Exception
	{
	 
	 HomePage log=new HomePage(driver);
	   log.Login("charm@kmail.com","charm123");
	   
	   
	    ContactList cl=new ContactList(driver);
	    cl  .ClickAddnewuser()
	  .EnterField(FName, LName, dob, EID, pno, SA1, SA2, CITY, STate, poscode,COUNTRY);
	  
	    cl.Asec_lastname();
	   
	    
	}
}
