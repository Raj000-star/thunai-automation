package Thunai_Application.Base;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Thunai_Application.Base.Utility;

public class Base {

	Utility u = new Utility();

	protected WebDriver driverbase;

	protected WebDriver getDriver() throws IOException, InvalidFormatException {
		if (driverbase == null) { 
			String browser = u.readExcelData("browsername");

			if (browser.equalsIgnoreCase("firefox")) {
				driverbase = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				driverbase = new EdgeDriver();
			} else {
				driverbase = new ChromeDriver(); // default
			}

			driverbase.manage().window().maximize();
			driverbase.get(u.readExcelData("url"));//testing

		}
		return driverbase;
	}
}



