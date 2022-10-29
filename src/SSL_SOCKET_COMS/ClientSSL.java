package SSL_SOCKET_COMS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocketFactory;

public class ClientSSL {
	public Socket client = null;
	public ClientSSL(String server, int port) throws UnknownHostException, IOException {
		SSLSocketFactory clientFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
	    client = clientFactory.createSocket(server, port);
	    
	}
	public void startClient() {
		System.out.println("Client ready");
		new Thread() {
			public void run() {
				try {
					// crytographic key or something
					double aMessage = 2.0;
					PrintWriter output = new PrintWriter(client.getOutputStream());
	                output.println(String.valueOf(aMessage));
	                output.flush();
	                System.out.println("Client message sent to server");
	                BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
	                String received = input.readLine();
	                System.out.println("Received server response : " + received);
	                client.close();				   
	               
			    }catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
		   }
	   }.start();
   }
   
}
