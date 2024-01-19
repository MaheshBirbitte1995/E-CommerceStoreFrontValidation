package Google_sheet_Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

import java.security.GeneralSecurityException;

import java.util.List;

public class GoogleSheetSeleniumExample {

	public static void main(String[] args) throws IOException, GeneralSecurityException, InterruptedException {

		//System.setProperty("Webdriver.chrome.driver", "./chromedriver_win32");

		WebDriver   driver = new ChromeDriver();
		ChromeOptions options =  new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");




		// Navigate to Google Sheets

		String Url="https://docs.google.com/spreadsheets/d/1_BE8gXMsgyzOLKKwlBTh3zJQMYwU0w5tvgMPGhdA9r0/edit#gid=1610588938";

		driver.get(Url);

		// Assuming you are already signed in to your Google account

		// Locate and click on the sheet you want to work with

		WebElement sheetLink = driver.findElement(By.linkText("Sheet6"));

		sheetLink.click();

		// Read data from the sheet

		readDataFromSheet(driver);

		// Write data to the sheet

		writeDataToSheet(driver, "Hello", "World");

		// Close the browser

		driver.quit();

	}

	private static void readDataFromSheet(WebDriver driver) {

		// Implement code to read data from the sheet using Selenium

		// Example:

		List<WebElement> cells = driver.findElements(By.xpath("//div[@class='grid-container']//div[@class='cell-input']"));

		for (WebElement cell : cells) {

			System.out.println("Cell Value: " + cell.getText());

		}

	}

	private static void writeDataToSheet(WebDriver driver, String value1, String value2) throws InterruptedException {

		// Implement code to write data to the sheet using Selenium

		// Example:

		WebElement cell1 = driver.findElement(By.xpath("//div[@class='grid-container']//div[@class='cell-input'][1]"));

		cell1.click();

		cell1.sendKeys(value1);

		WebElement cell2 = driver.findElement(By.xpath("//div[@class='grid-container']//div[@class='cell-input'][2]"));

		cell2.click();

		cell2.sendKeys(value2);

		// You may need to add a delay to ensure the data is written before moving on

		Thread.sleep(2000);

	}

}


