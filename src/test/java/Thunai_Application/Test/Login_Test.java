package Thunai_Application.Test;

import Thunai_Application.Base.Base;
import Thunai_Application.Page.Login_Page;
import Thunai_Application.Base.Utility;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Login_Test extends Base {

	Login_Page loginPage;
	Utility utility = new Utility();

	@BeforeClass
	public void setup() throws Throwable {
		// utility.loadExcelData();

		loginPage = new Login_Page(getDriver());
	}

	@Test
	public void verifyLoginFunctionality() throws Exception {

		loginPage.waitUntilNoRefresh();

		loginPage.clickOkButton();

		// loginPage.clickOkButton();

		loginPage.clickEmailField();

		loginPage.clickContinueButtonAfterEmail();

		loginPage.selectTenant();
		loginPage.clickPasswordField();
		loginPage.clickContinueButtonAfterPassword();

		// Utility.takeScreenshot(getDriver(), "LoginPage");

		// assertion

		// Assert.assertTrue(loginPage.getLogo().isDisplayed(), "Logo is not displayed
		// on home page..");

	}

	@AfterClass
	public void tearDown() {
		if (driverbase != null) {
			driverbase.quit(); // ✅ This uses the actual driver from Base
		}
	}
}
