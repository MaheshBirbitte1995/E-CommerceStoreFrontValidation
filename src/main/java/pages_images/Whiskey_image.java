
package pages_images;
 
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
 
public class Whiskey_image {
 
	private WebDriver driver;
 
 
 
	public Whiskey_image(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
 
	}
 
 
	public void whiskey_image_count() throws InterruptedException, Throwable {
 
		int implicitWaitTime = 10; // You can change this value based on your requirements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
 
		Thread.sleep(3000) ;
 
		driver.findElement(By.xpath("//button[@class='over-btn']")).click();
		Thread.sleep(3000) ;
		driver.findElement(By.xpath("//button[@class='btn btn-primary mr-2']")).click();   
 
		for (int j = 1; j < 39; j++) {
		     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		    List<WebElement> disc = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@rv-src='product.image']")));
 
		    for (int i = 0; i < disc.size(); i++) {
		        try {
		            WebElement description = disc.get(i);
		            if (description.getAttribute("src").equals("https://assets.scocu.net/3830375668925515")) {
		                WebElement title = driver.findElement(By.xpath("(//*[@rv-title='product.name'])[" + (i + 1) + "]"));
		                System.out.println(title.getText());
//		                
//		                String path = System.getProperty("user.dir")+"//ProductTitles.xlsx";
//		                File src = new File(path);
//		                FileInputStream fis = new FileInputStream(src);
//		                XSSFWorkbook wb = new XSSFWorkbook(fis);
//		                XSSFSheet sh1 = wb.getSheet("Sheet1");
//		                File fout = new File(path);
//		                FileOutputStream fos = new FileOutputStream(fout);
//		                sh1.getRow(i).getCell(j).setCellValue("aigaurav");
//		                wb.write(fos);
		             
		            }
		        } catch (StaleElementReferenceException e) {
		            // Handle StaleElementReferenceException
		            disc = driver.findElements(By.xpath("//*[@rv-src='product.image']"));
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
 
 
 
 