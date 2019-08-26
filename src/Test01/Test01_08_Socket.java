package Test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Test01_08_Socket {

	public static void main(String[] args) {
		String hostname = "localhost";
		int port = 80;

		try (Socket sock = new Socket(hostname, port);
				BufferedReader from = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				PrintWriter to = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()))) {
			to.print("hello");
			to.flush();
//			for (String l = null; (l = from.readLine()) != null;) {
//				System.out.println(l);
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
