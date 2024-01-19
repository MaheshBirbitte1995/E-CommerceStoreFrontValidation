package pages_images;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Beer_images {

	
	private WebDriver driver;
	
	
	
	
	
	public Beer_images(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void Beer_images_count() throws InterruptedException {
	
		
		
		
		

		int implicitWaitTime = 10; // You can change this value based on your requirements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
 
		Thread.sleep(3000) ;
 
		//Are you 21 or older? The products available here are age restricted.
		driver.findElement(By.xpath("//button[@class='over-btn']")).click();
		Thread.sleep(3000) ;
		
		//This website uses cookies to ensure you get the best experience on our website. By clicking Accept, you agree to our use of cookies
		driver.findElement(By.xpath("//button[@class='btn btn-primary mr-2']")).click();   
 
		driver.findElement(By.xpath("//a[@title='Beer']")).click();
		Thread.sleep(2000) ;
		
		
		for (int j = 1; j < 159; j++) {
		     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		    List<WebElement> disc = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@rv-src='product.image']")));

    	
		    for (int i = 0; i < disc.size(); i++) {
		        try {
		            WebElement description = disc.get(i);
		            if (description.getAttribute("src").equals("https://assets.scocu.net/3830375668925515")) {
		                WebElement title = driver.findElement(By.xpath("(//*[@rv-title='product.name'])[" + (i + 1) + "]"));
		                System.out.println(title.getText());
		                
		            }
		        } catch (StaleElementReferenceException e) {
		            // Handle StaleElementReferenceException
		            disc = driver.findElements(By.xpath("//*[@rv-src='product.image']"));
		            i--; // Re-adjust the index
		        }
		    }
 
		    Thread.sleep(2000); // Consider using WebDriverWait instead of static waits
 
		    WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='rgt ng-star-inserted']")));
		    nextButton.click();
 
		    Thread.sleep(6000); // Consider using WebDriverWait instead of static waits
		}

    	
    	
    	
    	
    }

	}
	
	
	
	
	
	

