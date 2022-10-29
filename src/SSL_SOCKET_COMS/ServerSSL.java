package SSL_SOCKET_COMS;

import java.io.IOException;
import java.net.ServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerSSL {
	private ServerSocket serverSocket;
	public ServerSSL(int port) throws IOException {
		SSLServerSocketFactory serverFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		serverSocket = serverFactory.createServerSocket(port);	
	}
	public void startServer() {
        System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + " ...");
		new Thread() {
			public void run() {
				try {
					Socket aClient = serverSocket.accept();
			        System.out.println("Just connected to " + aClient.getRemoteSocketAddress());
			        
		            aClient.setSoLinger(true, 1000);
		            BufferedReader input = new BufferedReader(new InputStreamReader(aClient.getInputStream()));
		            String received = input.readLine();
		            System.out.println("Receibed from client: " + received);
		            PrintWriter output = new PrintWriter(aClient.getOutputStream());
		            output.println("yes");
		            output.flush();
		            aClient.close();					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	
	}
}
