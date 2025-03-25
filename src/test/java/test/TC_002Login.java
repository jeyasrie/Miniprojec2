package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.HomePage;

public class TC_002Login extends ProjectSpecificationMethod {
	
	@BeforeTest
	public void setup()
	{
		sheetname="logindata";
		testName="Login Test";
		testDescription="Testing the login functionality with positive and negative cases";
		testAuthor=" jeyasri";
		testCategory="Smoke Testing";
	}
	@Test(dataProvider="readdata")
	public void loginTest(String email_id,String password,String TestType,String actualTxt) throws Exception {
		
		
		
	  HomePage log=new HomePage(driver);
	   log.Login(email_id,password);
	   log.validateLogin(TestType,actualTxt);
	   
	}

}
