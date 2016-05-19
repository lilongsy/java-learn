import java.net.URL;
import java.io.*;
import java.util.Scanner;

public class RetrivePage{
	public static String downloadPage(String path) {
		try{
			URL pageURL = new URL(path);
			Scanner scanner = new Scanner(new InputStreamReader(pageURL.openStream(), "utf-8"));
			scanner.useDelimiter("\\z");
			StringBuilder pageBuffer = new StringBuilder();
			while (scanner.hasNext()) {
				pageBuffer.append(scanner.next());
			}
			return pageBuffer.toString();
		
		} catch (Exception e) {
			
			return "Error";
		}
	}
	
	public static void main(String[] args) {
		System.out.println(RetrivePage.downloadPage("http://www.iqilu.com"));
	}
}
