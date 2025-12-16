package Thunai_Application.Base;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {

	/*
	 * public String readDatas(String key) throws FileNotFoundException, IOException
	 * { Properties p = new Properties(); // special Java class used to store
	 * p.load(new
	 * FileInputStream("./src/test/resources/Thunai_TestData.Properties")); // opens
	 * a file so Java can read from it.// String value = p.getProperty(key); return
	 * value; }
	 */
	 

	public String readExcelData(String key) {
	    try (InputStream is = getClass()
	            .getClassLoader()
	            .getResourceAsStream("TestData/Thunai_TestData.xlsx")) {

	        if (is == null) {
	            throw new RuntimeException("Excel file not found in classpath");
	        }

	        try (Workbook workbook = new XSSFWorkbook(is)) {
				Sheet sheet = workbook.getSheet("Test_Data");

				for (Row row : sheet) {
				    Cell keyCell = row.getCell(0);
				    Cell valueCell = row.getCell(1);

				    if (keyCell != null &&
				        keyCell.getStringCellValue().equalsIgnoreCase(key)) {

				        return valueCell.getStringCellValue();
				    }
				}

				workbook.close();
			}
	        return null;

	    } catch (Exception e) {
	        throw new RuntimeException("Failed to read Excel file", e);
	    }
	}


	public static String takeScreenshotWithHighlight(WebDriver driver, WebElement element, String screenshotName) {
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String destPath = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + "_" + timestamp + ".png";

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    String originalStyle = element.getAttribute("style");

	    try {
	        // Apply temporary highlight
	        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", 
	                         element, "border: 3px solid red; border-style: dashed;");

	        // Take screenshot
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(srcFile, new File(destPath));

	        System.out.println("✅ Screenshot with highlight saved at: " + destPath);
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        // Restore original style (so UI is not changed)
	        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
	    }
	    return destPath;
	}


}
