package Thunai_Application.Test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Thunai_Application.Base.Base;
import Thunai_Application.Page.Login_Page;
import Thunai_Application.Page.signIn;

public class signIn_Test extends Base{

	Login_Page loginPage;
	signIn signin; 
	
	@BeforeClass
	public void setUp() throws IOException, InvalidFormatException {
		loginPage=new Login_Page(getDriver());
		
	}
	
	@Test
	public void verify_Signin_Functionality() throws InterruptedException, IOException, InvalidFormatException {
		
		loginPage.clickOkButton();
		signin = new signIn(getDriver());
		signin.click_Sign_Up();
		signin.enter_Email();
		signin.create_Account();
		//signin.verify_Email();
		
		//Thread.sleep(10000);
	}
}
