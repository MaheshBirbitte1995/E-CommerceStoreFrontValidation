package Google_sheet_Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;

public class googleAuthorizeUtil {


	private static final String APPLICATION_NAME = "Sheet6";

	public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
	Credential credential = googleAuthorizeUtil.authorize();
		return new Sheets.Builder(
				GoogleNetHttpTransport.newTrustedTransport(), 
				JacksonFactory.getDefaultInstance(), credential)
				.setApplicationName(APPLICATION_NAME)
				.build();
	}
	
	
	
	
	

	public static Credential authorize() throws IOException, GeneralSecurityException {

		// build GoogleClientSecrets from JSON file

		List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);
		return null;

		// build Credential object

		
	}



	

}
