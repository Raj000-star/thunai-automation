import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public WebDriver driver;

	JavaUtility j = new JavaUtility();
	
	public void setUp() throws FileNotFoundException, IOException {
		if (j.readDataFromProperty("browsername").equals("chrome")) {
			driver = new ChromeDriver();
		} else if (j.readDataFromProperty("browsername").equals("edge")) {
			driver = new EdgeDriver();
		} else if (j.readDataFromProperty("browsername").equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(j.readDataFromProperty("url"));

	}
}
