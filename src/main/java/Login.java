import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Login Page Object representing the login flow.
 * Follows GNU-style formatting adapted to Java standards.
 */
public class Login {

    private WebDriver driver;
    private JavaUtility javaUtility = new JavaUtility();

    // Locators
    @FindBy(xpath = "//button[normalize-space()='Okay']")
    private WebElement newVersionButton;

    @FindBy(xpath = "//input[@placeholder='name@company.com']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@class='w-full py-3 px-4 rounded-lg font-medium bg-primary text-white focus:bg-brand_focus disabled:cursor-not-allowed disabled:hover:scale-100 disabled:hover:shadow-none flex items-center justify-center gap-2 group']")
    private WebElement firstSignInButton;

    @FindBy(xpath = "//input[@placeholder='Enter your password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class='w-full py-3 px-4 rounded-lg font-medium bg-primary text-white focus:bg-brand_focus disabled:cursor-not-allowed disabled:hover:scale-100 disabled:hover:shadow-none flex items-center justify-center gap-2 group']")
    private WebElement secondSignInButton;

    @FindBy(xpath = "//button[@class='w-full flex items-center justify-center gap-3 px-4 py-3 border border-gray-300 rounded-lg hover:bg-gray-50 transition duration-200']")
    private WebElement googleSignInButton;

    /**
     * Constructor initializes web elements.
     *
     * @param driver WebDriver instance passed from test class
     */
    public Login(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks on the 'Okay' button if new version prompt appears.
     */
    public void acceptNewVersion()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(newVersionButton));
        newVersionButton.click();
    }

    /**
     * Reads email from property file and returns it.
     *
     * @return String email
     * @throws IOException if property file is missing
     */
    public String getEmailFromProperty() throws IOException
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        return javaUtility.readDataFromProperty("email");
    }

    /**
     * Clicks on the first login button.
     */
    public void clickFirstLogin()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstSignInButton));
        firstSignInButton.click();
    }

    /**
     * Sends password to password field.
     *
     * @param password user's password
     */
    public void enterPassword(String password)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
    }

    /**
     * Clicks on the final login button.
     */
    public void clickFinalLogin()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(secondSignInButton));
        secondSignInButton.click();
    }

    /**
     * Clicks the sign-in with Google button.
     */
    public void clickGoogleSignIn()
    {
        googleSignInButton.click();
    }

    // Accessors (only included if necessary)
    public WebElement getEmailInput()     { return emailInput; }
    public WebElement getFirstSignIn()    { return firstSignInButton; }
    public WebElement getPasswordInput()  { return passwordInput; }
    public WebElement getSecondSignIn()   { return secondSignInButton; }
    public WebElement getGoogleSignIn()   { return googleSignInButton; }

    public void setEmailInput(WebElement email)              { this.emailInput = email; }
    public void setFirstSignIn(WebElement signIn)            { this.firstSignInButton = signIn; }
    public void setPasswordInput(WebElement password)        { this.passwordInput = password; }
    public void setSecondSignIn(WebElement signIn)           { this.secondSignInButton = signIn; }
    public void setGoogleSignIn(WebElement googleButton)     { this.googleSignInButton = googleButton; }
}
