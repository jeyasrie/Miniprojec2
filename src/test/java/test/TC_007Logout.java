package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.ContactList;
import page.HomePage;

public class TC_007Logout  extends ProjectSpecificationMethod{
	
	@BeforeTest
	public void setup()
	{
		testName=" logout";
		testDescription="Testing the logout function";
		testAuthor="Jeyasri";
		testCategory="Smoke Testing";
	}
	@Test
	public void logoutfunction()
	
	{
		
		 HomePage log=new HomePage(driver);
		   log.Login("charm@kmail.com","charm123");
		   
		ContactList cl=new ContactList(driver);
		cl.Clicklogout();
	}

}
