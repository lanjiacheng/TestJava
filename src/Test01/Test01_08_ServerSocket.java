package Test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Test01_08_ServerSocket {

	private static class HttpHandler implements Runnable {
		private final Socket sock;

		HttpHandler(Socket client) {
			this.sock = client;
		}

		public void run() {
			try (BufferedReader from = new BufferedReader(new InputStreamReader(sock.getInputStream()));
					PrintWriter to = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()))) {
//				to.print("hello too");
//				to.flush();
				for (String l = null; (l = from.readLine()) != null;) {
					System.out.println(l);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int port = 80;
			ServerSocket ss = new ServerSocket(port);
			for (;;) {
				Socket client = ss.accept();
				HttpHandler hndlr = new HttpHandler(client);
				new Thread(hndlr).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
