package Thunai_Application.Page;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.org.apache.xml.internal.security.Init;

import Thunai_Application.Base.Base;
import Thunai_Application.Base.Utility;

public class common_Agents extends Base {

	WebDriver driver;
	Utility utility = new Utility();
	private Actions actions;

	// locators

	@FindBy(xpath = "//span[normalize-space()='Agents']")
	private WebElement agents;

	@FindBy(xpath = "//button[contains(.,'Create New Agent')]\r\n"+ "")
	private WebElement create_New_Agent;

	// iframe element
	@FindBy(xpath = "//iframe[@class='h-full w-full' and contains(@src,'agent.thunai.ai')]\r\n"+ "")
	private WebElement iframe;

	@FindBy(xpath = "//input[@id='agent-name' and @placeholder='Enter agent name...']\r\n" + "")
	private WebElement enter_Agent_Name;

	@FindBy(xpath = "//button[contains(.,'Submit')]\r\n"+ "")
	private WebElement submit;

	@FindBy(xpath = "//button[contains(@class,'bg-background') and normalize-space()='Cancel']\r\n" + "")
	private WebElement cancel;

	@FindBy(xpath = "//button[normalize-space()='Configure']\r\n" + "")
	private WebElement configure;

	@FindBy(xpath = "//input[@id='agent-name' and @placeholder='Enter agent name']\r\n" + "")
	private WebElement agent_Name;

	@FindBy(xpath = "//class[@id= 'agent-description' and @placeholder='Brief description of what this agent does']")
	private WebElement agent_Description;

	@FindBy(xpath = "//class[@id='agent-instructions' and @placeholder='Provide step-by-step instructions for how the agent should behave. Be specific about the agent's role, responsibilities, and decision-making process'")
	private WebElement agent_Instructions;

	@FindBy(xpath = "//button[@role='switch']\r\n" + "")
	private WebElement brain_Toogle_Button;

	@FindBy(xpath = "//button[@role='switch']\r\n" + "")
	private WebElement analytics_Toogle_Button;

	@FindBy(xpath = "//button[@role='switch']\r\n" + "")
	private WebElement canvas_Toogle_Button;

	@FindBy(xpath = "//button[@role='switch']\r\n" + "")
	private WebElement mcp_Toogle_Button;

	@FindBy(xpath = "//button[@role='switch']")
	private WebElement voice;

	@FindBy(xpath = "//button[@role='switch']")
	private WebElement chat;

	@FindBy(xpath = "//button[@role='switch']")
	private WebElement email;

	@FindBy(xpath = "//button[@role='switch']")
	private WebElement meetings;

	@FindBy(xpath = "//button[.//svg[@class='lucide lucide-save'] and normalize-space()='Save Agent']")
	private WebElement save_Agent;

	/*
	 * @FindBy(xpath="") private WebElement ;
	 * 
	 * @FindBy(xpath="") private WebElement ;
	 * 
	 * @FindBy(xpath="") private WebElement ;
	 */

	// constructor

	public common_Agents(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	// action methods

	public void click_Common_Agents() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(getCommon_Agents()));
		wait.until(ExpectedConditions.elementToBeClickable(getCommon_Agents()));
		// ✅ Screenshot with element highlighted (only in screenshot, not while running)
		Utility.takeScreenshotWithHighlight(driver, getCommon_Agents(), "Common-Agent");

		// Perform click
		getCommon_Agents().click();

	}

	/**
	 * Click the "Create New Agent" button inside the cross-origin iframe.
	 * 
	 * @param iframeSrc The iframe URL
	 */

	public void click_Create_New_Agent() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
		wait.until(ExpectedConditions.visibilityOf(getCreate_New_Agent()));
		wait.until(ExpectedConditions.elementToBeClickable(getCreate_New_Agent())).click();
		Utility.takeScreenshotWithHighlight(driver, getCreate_New_Agent(), "Create_New_Agent");
		driver.switchTo().defaultContent();
		//Utility.takeScreenshot(driver, "Create Button");
	}

	public void enter_Agent_Name() throws FileNotFoundException, IOException, InvalidFormatException {
	 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
	    wait.until(ExpectedConditions.visibilityOf(getEnter_Agent_Name()));
		wait.until(ExpectedConditions.elementToBeClickable(getEnter_Agent_Name())).click();
		getEnter_Agent_Name().sendKeys(utility.readExcelData("common_agent_test"));
		Utility.takeScreenshotWithHighlight(driver, getEnter_Agent_Name(), "Enter_Agent_name");
	    driver.switchTo().defaultContent();
	}




	public void click_Submit_Button() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    driver.switchTo().defaultContent();
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
	            By.xpath("//iframe[contains(@src,'agent.thunai.ai')]")
	    ));

	    wait.until(ExpectedConditions.elementToBeClickable(getSubmit())).click();

	    driver.switchTo().defaultContent();
	}


	/*
	 * public void click_Configure_Button() {
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
	 * wait.until(ExpectedConditions.visibilityOf(getConfigure()));
	 * wait.until(ExpectedConditions.elementToBeClickable(getConfigure()));
	 * getConfigure().click(); driver.switchTo().defaultContent();
	 * 
	 * }
	 * 
	 * public void enter_Agent_Description() throws FileNotFoundException,
	 * IOException {
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
	 * wait.until(ExpectedConditions.visibilityOf(getAgent_Description()));
	 * wait.until(ExpectedConditions.elementToBeClickable(getAgent_Description()));
	 * getAgent_Description().click();
	 * getAgent_Description().sendKeys(utility.readDatas("agent_Description"));
	 * driver.switchTo().defaultContent();
	 * 
	 * }
	 */
	
	public WebElement getCommon_Agents()                          {return agents;}
	public WebElement getCreate_New_Agent()                       {return create_New_Agent;}
	public WebElement getEnter_Agent_Name()                       {return enter_Agent_Name;}
    public WebElement getSubmit()                                 {return submit;}
    public WebElement getCancel()                                 {return cancel;}
	public WebElement getConfigure()                              {return configure;}
    public WebElement getAgent_Name()                             {return agent_Name;}
    public WebElement getAgent_Description()                      {return agent_Description;}
    public WebElement getAgent_Instructions()                     {return agent_Instructions;}
    public WebElement getBrain_Toogle_Button()                    {return brain_Toogle_Button;}
    public WebElement getAnalytics_Toogle_Button()                {return analytics_Toogle_Button;}
    public WebElement getCanvas_Toogle_Button()                   {return canvas_Toogle_Button;}
	public WebElement getMcp_Toogle_Button()                      {return mcp_Toogle_Button;}
    public WebElement getVoice()                                  {return voice;}
	public WebElement getChat()                                   {return chat;}
	public WebElement getEmail()                                  {return email;}
	public WebElement getMeetings()                               {return meetings;}
	public WebElement getSave_Agent()                             {return save_Agent;}

}