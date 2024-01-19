package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

public class Liquor_and_Spirits_category {

	
	
	
	private WebDriver driver;
	
	
	
	
	
	
	
	
	public Liquor_and_Spirits_category(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void  Liquor_and_Spiriting() throws InterruptedException   {
		
		
		int implicitWaitTime = 10; 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
		driver.manage().window().maximize();
		
		
		Thread.sleep(3000) ;
		//Are you 21 or older? The products available here are age restricted.
		
		driver.findElement(By.xpath("//button[@class='over-btn']")).click();
		Thread.sleep(1000) ;
		
		//This website uses cookies to ensure you get the best experience on our website. By clicking Accept, you agree to our use of cookies
		driver.findElement(By.xpath("//button[@class='btn btn-primary mr-2']")).click();
		
		Thread.sleep(3000) ;
		driver.findElement(By.xpath("//a[@title='Liquor & Spirits']")).click();
		Thread.sleep(2000) ;
		driver.findElement(By.xpath("//h5[@class='info-title']")); 
		int l=0;
		int k=0;
		for (int j = 1; j < 122; j++) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
			List<WebElement> disc = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@rv-title='product.description']")));

			for (int i = 0; i < disc.size(); i++) {
				try {
					WebElement description = disc.get(i);
					if (description.getText().equals("No description found.")) {
						WebElement title = driver.findElement(By.xpath("(//*[@rv-title='product.name'])[" + (i + 1) + "]"));
						String titlevalue= title.getText();
						System.out.println(titlevalue);

					
					}
				} catch (StaleElementReferenceException e) {
					// Handle StaleElementReferenceException
					disc = driver.findElements(By.xpath("//*[@rv-title='product.description']"));
					i--; // Re-adjust the index
				}
			}

			Thread.sleep(1000); // Consider using WebDriverWait instead of static waits

			WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-chevron-right']")));
			nextButton.click();

			Thread.sleep(6000); // Consider using WebDriverWait instead of static waits





		}

	}
	


		
	}
	
	
	
	
	
	
	
	
	
	
	

