package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.AddContact;
import page.ContactDetails;
import page.ContactList;
import page.HomePage;

public class TC_003ContactListTest extends ProjectSpecificationMethod {
	
	@BeforeTest
	public void setup()
	{
		sheetname="addContact";
		testName="add contact Test";
		testDescription="Testing  validate the add contact field";
		testAuthor="Jeyasri";
		testCategory="Smoke Testing";
	}

	@Test(dataProvider="readdata")
	public void Contact(String FName,String LName,String dob,String EID,String pno,String SA1,String SA2,String CITY,String STate,String poscode,String COUNTRY,String Testtype,String EXpected) throws Exception
	{
	 
	 HomePage log=new HomePage(driver);
	   log.Login("guna123@kmail.com","guna123")
	   .ClickAddnewuser()
	   .EnterField(FName, LName, dob, EID, pno, SA1, SA2, CITY, STate, poscode, COUNTRY)
	  
	    .validateuserField(Testtype, EXpected);
	   }
}