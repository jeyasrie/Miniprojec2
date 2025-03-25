package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import page.HomePage;

public class TC_001SignUp extends ProjectSpecificationMethod {
	
	@BeforeTest
	public void setpath() throws IOException
	{
		filepath="C:\\Users\\srije\\eclipse-workspace\\ThinkingTester\\src\\test\\resources\\data\\signupdata.properties";
		readFromPropFile(filepath);
		testName="Signup Test";
		testDescription="Testing the signup page with positive and negative testcase";
		testAuthor="Jeyasri";
		testCategory="Smoke Testing";
	}
	@Test
	public void signupTest() throws IOException {
		
		
		HomePage signup=new HomePage(driver);
		signup.Clicksignup()
		.enterFirstName(prop.getProperty("fname"))
		.enterLastName(prop.getProperty("lname"))
		.enterMail(prop.getProperty("email"))
		.enterPasswd(prop.getProperty("password"))
		.ClickSubmit();
	
		}
	@Test
	public void invalidemailsignupTest() throws IOException {
		
		
		HomePage signup=new HomePage(driver);
		signup.Clicksignup()
		.enterFirstName(prop.getProperty("infname"))
		.enterLastName(prop.getProperty("inlname"))
		.enterMail(prop.getProperty("inemail"))
		.enterPasswd(prop.getProperty("inpassword"))
		.ClickSubmit();
	
	}

}
