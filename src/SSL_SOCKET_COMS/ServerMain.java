package SSL_SOCKET_COMS;

import SSL_SOCKET_COMS.ClientSSL;
import SSL_SOCKET_COMS.ServerSSL;


import java.io.IOException;

public class ServerMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// this goes in computer
	    System.setProperty("javax.net.ssl.keyStore", "certs/server/serverKey.jks");
	    System.setProperty("javax.net.ssl.keyStorePassword","servpass");
	    
	    // this goes on android
	    System.setProperty("javax.net.ssl.trustStore", "certs/client/clientTrustedCerts.jks");
	    System.setProperty("javax.net.ssl.trustStorePassword", "clientpass");
	    
	    // computer
	    new ServerSSL(8080).startServer();
	    // android
	    new ClientSSL("localhost",8080).startClient();

	}

}
