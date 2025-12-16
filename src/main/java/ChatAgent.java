

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChatAgent {

	WebDriver driver;
	

	// constructor
	ChatAgent(WebDriver driver) {
		this.driver = driver;
		// this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	// locators
	@FindBy(xpath = ("//div[normalize-space(text())='Chat Agents' and contains(@class, 'bg-custom-secondary')]"))
	WebElement chatagent;

	@FindBy(xpath = ("//button[normalize-space()='Create']"))
	WebElement create_button1;

	@FindBy(xpath = ("//div[@class='border rounded-lg p-4 cursor-pointer hover:shadow-md transition border-blue-500 shadow-lg bg-blue-50 text-blue-800']"))
	WebElement support_agent;

	@FindBy(xpath = ("//input[@placeholder='Enter chat agent name']"))
	WebElement agent_name;

	@FindBy(xpath = ("//div/button[normalize-space(text()) = 'Create' and contains(@class, 'bg-blue-600')]"))
	WebElement create_button2;

	// action methods
	public void select_ChatAgent() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(chatagent));
		chatagent.click();

	}

	public void CrateButton1() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(create_button1));
		wait.until(ExpectedConditions.elementToBeClickable(create_button1));
		// actions.moveToElement(create_button1).perform();
		create_button1.click();
	}

	public void agent1() {
		support_agent.click();
	}

	public void agentName() {

		agent_name.click();
		agent_name.sendKeys("SA15");
	}

	public void CrateButton2() {
		create_button2.click();
	}
}
