import java.net.Socket;
import java.io.*;

public class RetriveSocket {
	public static void main(String[] args) {
		try{
			String host = "test"; //主机名
			String file = "/"; //网页路径
			int port = 80; //端口号
			
			Socket s = new Socket(host, port);
			
			OutputStream out = s.getOutputStream();
			PrintWriter outw = new PrintWriter(out, false);
			outw.print("GET " + file + " HTTP/1.0\r\n");
			outw.print("Accept: text/plain, text/html, text/*\r\n");
			outw.print("\r\n");
			outw.flush(); //发送
			
			InputStream in = s.getInputStream();
			// 字节流转字符流，并设置编码
			InputStreamReader inr = new InputStreamReader(in, "utf-8");
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
