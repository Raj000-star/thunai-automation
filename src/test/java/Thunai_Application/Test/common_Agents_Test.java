package Thunai_Application.Test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Thunai_Application.Base.Base;
import Thunai_Application.Page.Login_Page;
import Thunai_Application.Page.common_Agents;

public class common_Agents_Test extends Base {

	Login_Page loginPage;
	common_Agents agents;

	@BeforeClass
	public void setUp() throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

		loginPage = new Login_Page(getDriver());

	}

	@Test
	public void create_agent() throws Exception {

		loginPage.clickOkButton();

		loginPage.clickEmailField();

		loginPage.clickContinueButtonAfterEmail();

		loginPage.selectTenant();
		loginPage.clickPasswordField();

		loginPage.clickContinueButtonAfterPassword();

		agents = new common_Agents(getDriver());

		agents.click_Common_Agents();

		agents.click_Create_New_Agent();

		agents.enter_Agent_Name();
		Thread.sleep(10000);
		agents.click_Submit_Button();
		Thread.sleep(10000);

		// agents.click_Configure_Button();

		//agents.enter_Agent_Description();

	}

	@AfterClass
	public void tearDown() {
		if (driverbase != null) {
			driverbase.quit(); // ✅ This uses the actual driver from Base
		}
	}
}