package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class No_description {

	private WebDriver driver;






	// constructor calling
	public No_description(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);

	}

	public String excel_operations(String value) throws IOException {


		//fos.close();
		return value;



	}



	public void products_titles() throws InterruptedException, IOException {

		int implicitWaitTime = 10; // You can change this value based on your requirements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));

		Thread.sleep(3000) ;

		//
		driver.findElement(By.xpath("//button[@class='over-btn']")).click();
		Thread.sleep(3000) ;
		driver.findElement(By.xpath("//button[@class='btn btn-primary mr-2']")).click();   

		int l=0;
		int k=0;
		for (int j = 1; j < 39; j++) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
			List<WebElement> disc = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@rv-title='product.description']")));

			for (int i = 0; i < disc.size(); i++) {
				try {
					WebElement description = disc.get(i);
					if (description.getText().equals("No description found.")) {
						WebElement title = driver.findElement(By.xpath("(//*[@rv-title='product.name'])[" + (i + 1) + "]"));
						String titlevalue= title.getText();
						System.out.println(titlevalue);

						String path = System.getProperty("user.dir") + "/ExcelSheet/No_description_data.xlsx";

						File file = new File(path);
						File folFile =new File(path);

						FileInputStream fis = new FileInputStream(file);

						XSSFWorkbook book = new XSSFWorkbook();

						// Check if the sheet 3exists

						XSSFSheet sheet = book.getSheet("Whiskey");

						if (sheet == null) {

							// Sheet not found, handle accordingly (create it or throw an error)

							System.out.println("Sheet 'Whiskey' not found!");

						} else {

							// Sheet found, proceed with your code

							sheet.getRow(0).getCell(0).setCellValue(titlevalue);

							// FileOutputStream

							FileOutputStream fos = new FileOutputStream(folFile );

							// Write to the workbook

							book.write(fos);

							// Close streams

							fos.close();

						}

						fis.close();

					}
				} catch (StaleElementReferenceException e) {
					// Handle StaleElementReferenceException
					disc = driver.findElements(By.xpath("//*[@rv-title='product.description']"));
					i--; // Re-adjust the index
				}
			}

			Thread.sleep(1000); // Consider using WebDriverWait instead of static waits

			WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='rgt ng-star-inserted']")));
			nextButton.click();

			Thread.sleep(6000); // Consider using WebDriverWait instead of static waits





		}

	}
}		





