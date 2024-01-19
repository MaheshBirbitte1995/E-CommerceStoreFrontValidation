package Google_sheet_Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.Response;
import com.google.api.services.sheets.v4.model.ValueRange;

public class data_from_Google_Sheet {

	
	

	
	private static final String APPLICATION_NAME ="Data Validations";
	
	private static final String JSON_FACTORY="JacksonFactory.getDefaultInstance";
	
	private static final String TOKENS_DIRECTORY_PATH="D:\\wide-ratio-411407-c417d7155c2e.json";
	
	private static final List<String> Scopes = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
	
	private static final String CREDENTIALS_FILE_PATH ="D:\\wide-ratio-411407-c417d7155c2e.json";
	
	
	private static Credential createCredentials(final NetHttpTransport HTTP_TRNSPORT) throws FileNotFoundException {
	
	
	File initiatefile =  new File("D:\\wide-ratio-411407-c417d7155c2e.json");
	FileInputStream in = new FileInputStream(initiatefile);
	
	if (in==null) {throw new FileNotFoundException("Resource not found : " +CREDENTIALS_FILE_PATH);

	
	}else {
		System.out.println("Found the file");
	}
		
		
		GoogleClientSecrets clientSecrets  = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
	
		GoogleAuthorizationCodeFlow authorizationCodeFlow  =  new GoogleAuthorizationCodeFlow(HTTP_TRNSPORT, JSON_FACTORY, CREDENTIALS_FILE_PATH, APPLICATION_NAME, Scopes)
	                                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
	                                .setAccessType("offline").build();
		LocalServerReceiver receiver = new LocalServerReceiver().Builder().setport(8888).build();
	                                
	                                
	                                
	                                
	
	return new AuthorizationCodeInstalledApp(authorizationCodeFlow, receiver).authorize("user");

	
	}
	
	
	public static List<List<Objects>> values  = Response.getValues();
	final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
	
	final String spreadsheetId = "";
	final String range ="";
	Sheets service =  new Sheets(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT)).setApplicationName(APPLICATION_NAME).build();
	ValueRange response =service.spreadsheets().values().get(SpreadsheetId,range).execute();
	List<List<Objects>> values =  Response.getValues();
	return values;
	
	
	
	
	
	
	
}