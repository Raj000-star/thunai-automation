package Thunai_Application.Page;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Thunai_Application.Base.Base;
import Thunai_Application.Base.Utility;

public class Login_Page extends Base {

	WebDriver driver;
	Utility utility = new Utility();
	Base base = new Base();

	/*
	 * @FindBy(xpath = ("//button[normalize-space()='Okay']")) private WebElement
	 * ok_Button;
	 */

	@FindBy(xpath = ("(//img[@class='w-[120px] mb-6'])[1]"))
	private WebElement logo;

	@FindBy(xpath = ("//img[@alt='Welcome']"))
	private WebElement login_Page_Images;

	@FindBy(xpath = ("//h1[normalize-space()='Welcome Back!']"))
	private WebElement welcomeback_Text;

	@FindBy(xpath = ("//input[@placeholder='name@company.com']"))
	private WebElement email_Text;

	@FindBy(xpath = ("//input[@placeholder='name@company.com']"))
	private WebElement email_Field;

	@FindBy(xpath = ("//p[normalize-space()='Please enter your email']"))
	private WebElement please_Enter_Your_Email_Text;

	@FindBy(xpath = ("//button[.//*[contains(text(),'Continue')]]\r\n"	+ ""))
	private WebElement continue_Button_1;

	
	  @FindBy(xpath = "//li[normalize-space()='Thunai QA Team']") private
	  WebElement thunai_QA_Team;
	 

	@FindBy(xpath = "//select[@formcontrolname='tenant_id']")
	private WebElement tenantDropdown;

	@FindBy(xpath = "//select[@formcontrolname='tenant_id']/option")
	private List<WebElement> tenantOptions;

	@FindBy(xpath = ("(//span[@class='px-2 bg-white text-gray-500'])[1]"))
	private WebElement or_Continue_With_Text;

	@FindBy(xpath = ("(//button[@class='w-full flex items-center justify-center gap-3 px-4 py-3 border border-gray-300 rounded-lg hover:bg-gray-50 transition duration-200'])[1]"))
	private WebElement continue_With_Google_Button_1;

	@FindBy(xpath = ("//p[@class='text-center text-textSecondary']"))
	private WebElement dont_Have_An_Account_Text;

	@FindBy(xpath = ("(//button[normalize-space()='Sign up'])[1]"))
	private WebElement signUp_Button_1;

	@FindBy(xpath = ("(//span[@class='text-sm text-gray-500 mr-2'])[1]"))
	private WebElement secured_By_Text_1;

	@FindBy(xpath = ("(//img[@class='h-11 lg:h-11 sm:h-8'])[1]"))
	private WebElement infisign_Logo_1;

	@FindBy(xpath = ("//p[normalize-space()='Version 1.0.8']"))
	private WebElement version108_Text;

	@FindBy(xpath = ("//p[normalize-space()='© 2025 Entrans. All Rights Reserved.']"))
	private WebElement entrans_All_Rights_Reserved_Text;

	@FindBy(xpath = ("//a[normalize-space()='Terms of Service']"))
	private WebElement terms_Of_Service_Link;

	@FindBy(xpath="//h3[normalize-space()='Please select the organization to proceed further']")
	private WebElement text;

	@FindBy(xpath = ("//a[normalize-space()='Privacy Policy']"))
	private WebElement privacy_Policy_Link;

	@FindBy(xpath = ("//label[normalize-space()='Password']"))
	private WebElement passwordText;

	@FindBy(xpath = ("//input[@placeholder='Enter your password']"))
	private WebElement passwordFiled;

	@FindBy(xpath = ("//button[normalize-space()='Forgot password?']"))
	private WebElement forgotPassword;

	@FindBy(xpath = ("//mat-icon[@role='img']"))
	private WebElement eyeImage;

	@FindBy(xpath = ("//button[.//*[contains(text(),'Continue')]]\r\n"+ ""))
	private WebElement continue_Button_2;

	/**
	 * constructor initializes WebElements
	 * 
	 * @param driver WebDriver instance passed from Base class
	 */

	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void waitUntilNoRefresh() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
	}
	
	public void clickOkButton() {
	    waitUntilNoRefresh();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Okay']"))).click();
	}


	public void clickEmailField() throws FileNotFoundException, IOException, InvalidFormatException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(getEmail_Field()));
		wait.until(ExpectedConditions.elementToBeClickable(getEmail_Field()));
		getEmail_Field().click();
		getEmail_Field().sendKeys(utility.readExcelData("email"));
		Utility.takeScreenshotWithHighlight(driver, getEmail_Field(), "Email");
	}

	// Clicks the continue button after entering email
	public void clickContinueButtonAfterEmail() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(getContinue_Button_1()));
		wait.until(ExpectedConditions.elementToBeClickable(getContinue_Button_1()));
		getContinue_Button_1().click();
		Utility.takeScreenshotWithHighlight(driver, getContinue_Button_1(), "Continue_Button_1");
	}


	public void selectTenant() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(getText()));
        wait.until(ExpectedConditions.elementToBeClickable(getText()));
        getText().click();
       thunai_QA_Team.click();
	}






	// Clicks the password input field
	public void clickPasswordField() throws FileNotFoundException, IOException, InvalidFormatException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(getPasswordFiled()));
		wait.until(ExpectedConditions.elementToBeClickable(getPasswordFiled()));
		getPasswordFiled().click();
		getPasswordFiled().sendKeys(utility.readExcelData("password"));
		Utility.takeScreenshotWithHighlight(driver, getPasswordFiled(), "Password");
	}

	// Clicks the continue button after entering password
	public void clickContinueButtonAfterPassword() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(getContinue_Button_2()));
		wait.until(ExpectedConditions.elementToBeClickable(getContinue_Button_2()));
		getContinue_Button_2().click();
		Utility.takeScreenshotWithHighlight(driver, getContinue_Button_2(), "Continue_Button_2");
	}


	
	
	//Accessors (only included if necessary)
		
	   // public WebElement getOk_Button()                                                              {return ok_Button;}
		public WebElement getLogo()                                                                   { return logo; }
		public WebElement getLogin_Page_Images()                                                      { return login_Page_Images; }
		public WebElement getWelcomeback_Text()                                                       { return welcomeback_Text; }
		public WebElement getEmail_Text()                                                             { return email_Text; }
		public WebElement getEmail_Field()                                                            { return email_Field; }
		public WebElement getPlease_Enter_Your_Email_Text()                                           { return please_Enter_Your_Email_Text; }
		public WebElement getText()                                                                   { return text;}
		//public List<WebElement> getTenant_id()                                                        {return tenant_id;}
		public WebElement getContinue_Button_1()                                                      { return continue_Button_1; }
		public WebElement getOr_Continue_With_Text()                                                  { return or_Continue_With_Text; }
		public WebElement getContinue_With_Google_Button_1()                                          { return continue_With_Google_Button_1; }
		public WebElement getDont_Have_An_Account_Text()                                              { return dont_Have_An_Account_Text; }
		public WebElement getSignUp_Button_1()                                                        { return signUp_Button_1; }
		public WebElement getSecured_By_Text_1()                                                      { return secured_By_Text_1; }
		public WebElement getInfisign_Logo_1()                                                        { return infisign_Logo_1; }
		public WebElement getVersion108_Text()                                                        { return version108_Text; }
		public WebElement getEntrans_All_Rights_Reserved_Text()                                       { return entrans_All_Rights_Reserved_Text; }
		public WebElement getTerms_Of_Service_Link()                                                  { return terms_Of_Service_Link; }
		public WebElement getPrivacy_Policy_Link()                                                    { return privacy_Policy_Link; }
		public WebElement getPasswordFiled()                                                          { return  passwordFiled; }
		public WebElement getPasswordText()                                                           {return passwordText;}
		public WebElement getForgotPassword()                                                         { return  forgotPassword; }
		public WebElement getEyeImage()                                                               { return  eyeImage; }
		public WebElement getContinue_Button_2()                                                      { return  continue_Button_2; }

		
	
}
	
	
	
	
	

	

	