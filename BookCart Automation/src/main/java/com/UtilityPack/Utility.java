package com.UtilityPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.google.common.io.Files;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility 
{
	public static void CaptureScreenshot (WebDriver driver, String Name) throws IOException
	{
		Date current = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd.MMM.yyyy hh.mm.ss");
		String d = date.format(current);
		
		Files.copy( ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), 
									new File("C:\\I-rise\\Notes\\Automation\\Screenshots\\"+Name+" "+d+".jpeg") );
		
	}
	
	public static String getExcelData(String sheet, int row, int column) throws EncryptedDocumentException, IOException
	{
		String path = "C:\\I-rise\\Notes\\Automation\\Test_Cases.xlsx";
		FileInputStream file = new FileInputStream(path); 
		
		String data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public static void mousehoverAndClick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}
	
	public static void scrollToElement (WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
