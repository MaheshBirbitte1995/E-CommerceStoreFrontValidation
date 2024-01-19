package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

			private WebDriver driver;

	@FindBy(xpath="//input[@id='email']")
	WebElement login_username;

	@FindBy(xpath="//input[@id='password']")
	WebElement login_password;

	@FindBy(xpath="//button[@class='btn login-btn text-white']")
	WebElement login_application;




	public LoginPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);


	}



	public void credentialsuser(String use) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver .manage().window().maximize();

		Thread.sleep(7000);

		Actions act = new Actions(driver);
		login_username.sendKeys("mahesh.shivaraj@uncode.io");


		act.sendKeys(Keys.ENTER).build().perform();


                 

	}


	public void credentialspass(String pass) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver .manage().window().maximize();

		Thread.sleep(7000);

		Actions act =  new Actions(driver);
		login_password.sendKeys("Test@123");


		act.sendKeys(Keys.ENTER).build().perform();


		Thread.sleep(9000);

		//driver.navigate().refresh();

	}



}














