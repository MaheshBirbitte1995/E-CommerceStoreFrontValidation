package Google_sheet_validations;


import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;



public class GoogleSheetsExample {

//private WebDriver driver;

     String Url="";
	private static final String SPREADSHEET_ID = "1_BE8gXMsgyzOLKKwlBTh3zJQMYwU0w5tvgMPGhdA9r0";
	private static final String RANGE = "Sheet6!A1:B2"; // Update with your sheet name and range
   
	public static void main(String[] args) throws IOException {
		//WebDriver driver = new ChromeDriver();
		
		Sheets sheetsService = createSheetsService();
		readDataFromGoogleSheet(sheetsService);
		writeDataToGoogleSheet(sheetsService);
	}

	private static Sheets createSheetsService() throws IOException {
		FileInputStream credentials = new FileInputStream("D:\\wide-ratio-411407-c417d7155c2e.json");
		GoogleCredential credential = GoogleCredential.fromStream(credentials)
				.createScoped(Arrays.asList("https://www.googleapis.com/auth/spreadsheets"));
		return new Sheets.Builder(credential.getTransport(), credential.getJsonFactory(), null)
				.setApplicationName("Sheet6")
				.build();
	}

	private static void readDataFromGoogleSheet(Sheets sheetsService) throws IOException {
		ValueRange response = sheetsService.spreadsheets().values().get(SPREADSHEET_ID, RANGE).execute();
		List<List<Object>> values = response.getValues();

		if (values == null || values.isEmpty()) {
			System.out.println("No data found.");
		} else {
			System.out.println("Data read from Google Sheet:");
			for (List<Object> row : values) {
				System.out.println(row);
			}
		}
	}

	private static void writeDataToGoogleSheet(Sheets sheetsService) throws IOException {
		ValueRange body = new ValueRange()
				.setValues(Arrays.asList(
						Arrays.asList("New Data 1", "New Data 2"),
						Arrays.asList("More Data 1", "More Data 2")
						));

		UpdateValuesResponse result = sheetsService.spreadsheets().values()
				.update(SPREADSHEET_ID, RANGE, body)
				.setValueInputOption("RAW")
				.execute();

		System.out.println("Data written to Google Sheet. Updated cells: " + result.getUpdatedCells());
	}	


}








