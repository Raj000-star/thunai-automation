package Thunai_Application.Page;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Thunai_Application.Base.Utility;

public class signIn {
	
	WebDriver driver;
	Utility utility = new Utility();

	//Locators
	@FindBy(xpath="//button[normalize-space()='Sign up']")
	private WebElement sign_Up;

	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath="//button[@type='submit']") 
	private WebElement create_Account;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement verify_Email;
	
	
	/*
	 * @FindBy(xpath="") private WebElement ;
	 * 
	 * @FindBy(xpath="") private WebElement ;
	 * 
	 * @FindBy(xpath="") private WebElement ;
	 * 
	 * @FindBy(xpath="") private WebElement ;
	 * 
	 * @FindBy(xpath="") private WebElement ;
	 * 
	 * @FindBy(xpath="") private WebElement ;
	 */
	
	//constructor
	
	public signIn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//action methods
	
	public void click_Sign_Up() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(getSign_Up()));
		wait.until(ExpectedConditions.elementToBeClickable(getSign_Up()));
		getSign_Up().click();
	}
	
	public void enter_Email() throws FileNotFoundException, IOException, InvalidFormatException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(getEmail()));
		wait.until(ExpectedConditions.elementToBeClickable(getEmail()));
		getEmail().click();
		getEmail().sendKeys(utility.readExcelData("email"));
	}
	    
	public void create_Account() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(getCreate_Account()));
		wait.until(ExpectedConditions.elementToBeClickable(getCreate_Account()));
		getCreate_Account().click();
	}

	public void verify_Email() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(getVerify_Email()));
		wait.until(ExpectedConditions.elementToBeClickable(getVerify_Email()));
		getVerify_Email().click();
	}

	public WebElement getSign_Up()                                             {return sign_Up;}
	public WebElement getEmail()                                               {return email;}
	public WebElement getCreate_Account()                                      {return create_Account;}
	public WebElement getVerify_Email()                                        {return verify_Email;}

	
	
	
	
	
	
	
	
	
	
	
	
}

