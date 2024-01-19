package Google_sheet_validations;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

public class title_name_price_validations {

	
	
	String url="https://docs.google.com/spreadsheets/d/1_BE8gXMsgyzOLKKwlBTh3zJQMYwU0w5tvgMPGhdA9r0/edit#gid=1463254203";
	private WebDriver driver;
	
	public title_name_price_validations( WebDriver driver) {
	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void title_name_price_validations_google() throws InterruptedException {
		
		int implicitwait=12;
		driver.manage().timeouts().implicitlyWait(implicitwait, TimeUnit.SECONDS);
		
		//driver.manage().window().maximize();
		
		Thread.sleep(3000) ;
		
		driver.get(url);
	}
	
	
}
