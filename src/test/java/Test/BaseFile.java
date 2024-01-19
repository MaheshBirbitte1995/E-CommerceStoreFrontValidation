package Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Date;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import Google_sheet_Test.GoogleSheets;

//import Google_sheet_Test.GoogleSheets;

import Utility.proper;
import pages.Beer_category;
import pages.Liquor_and_Spirits_category;
import pages.LoginPage;
import pages.No_description;
import pages.Other_Items;
import pages.Wine_CATEGORY;
import pages_images.Beer_images;
import pages_images.Liquor_and_spirits_images;
import pages_images.Other_items_images;
import pages_images.Whiskey_image;
import pages_images.Wine_Images;

public class BaseFile {


	public LoginPage  loginpageCC;
	public No_description  No_descriptionCC;
	public Liquor_and_Spirits_category  Liquor_and_SpiritsCC; 
	public Other_Items Other_Items_CC;
	public 	Wine_CATEGORY Wine_CATEGORY_CC;
	public 	Beer_category Beer_category_CC; 
	public Whiskey_image Whiskey_image_CC;
	public Liquor_and_spirits_images Liquor_and_spirits_images_CC;
	public Other_items_images Other_items_images_CC;
	public Wine_Images  Wine_Images_CC;
	public Beer_images  Beer_images_cc; 

	public static WebDriver driver;

	public static String dateFormatted;


	@BeforeSuite
	public void init() throws IOException, InterruptedException, GeneralSecurityException {

		ChromeOptions options =  new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	    driver =  new ChromeDriver();
		driver.get(proper.prop("Url"));



//		SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyyyy HH.mm.ss");
//		Date date = new Date();
//		dateFormatted = formatter.format(date);

		GoogleSheets.authorize(); //Authorization
		GoogleSheets.getSpreadsheetInstance();	//Getting Spreadsheet instance	
		new GoogleSheets().createSheetAndColumn(dateFormatted,Arrays.asList("name","description","price"));

		//Creating the Sheet with current datetime along with the result columns



	

     // driver.manage().window().maximize();

}


	@BeforeClass
	public void obj() {

		loginpageCC =  new LoginPage(driver);
		No_descriptionCC =  new No_description(driver);
		Liquor_and_SpiritsCC = new Liquor_and_Spirits_category(driver);
		Other_Items_CC =  new Other_Items(driver);
		Wine_CATEGORY_CC = new Wine_CATEGORY(driver);
		Beer_category_CC =  new Beer_category(driver);
		Whiskey_image_CC =  new Whiskey_image(driver);
		Liquor_and_spirits_images_CC = new Liquor_and_spirits_images(driver);
		Other_items_images_CC = new Other_items_images(driver);
		Wine_Images_CC =  new Wine_Images(driver);
		Beer_images_cc =  new Beer_images(driver);




	}




}
