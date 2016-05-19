import java.net.Socket;
import java.io.*;

public class RetriveSocket {
	public static void main(String[] args) {
		try{
			String host = "test";
			String file = "/";
			int port = 80;
			
			Socket s = new Socket(host, port);
			
			OutputStream out = s.getOutputStream();
			PrintWriter outw = new PrintWriter(out, false);
			outw.print("GET " + file + " HTTP/1.0\r\n");
			outw.print("Accept: text/plain, text/html, text/*\r\n");
			outw.print("\r\n");
			outw.flush();
			
			InputStream in = s.getInputStream();
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
