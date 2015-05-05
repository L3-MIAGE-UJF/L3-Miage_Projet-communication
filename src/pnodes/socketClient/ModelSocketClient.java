package pnodes.socketClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import onodes.Model;

public class ModelSocketClient implements Model {
	private String hostnameIP;
	private Socket socket;
	
	private BufferedReader in;
	private PrintWriter out;

	private static final String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	public ModelSocketClient(String serverIporName, int port) {
		System.out.println("Connexion au serveur "+serverIporName+" sur le port "+port);
		try {

			Pattern patternIP = Pattern.compile(IPADDRESS_PATTERN);
			Matcher matcher = patternIP.matcher(serverIporName);

			if (matcher.matches()) {
				hostnameIP = serverIporName;
			} else {
				hostnameIP = InetAddress.getByName(serverIporName)
						.getHostAddress();
			}

			socket = new Socket(hostnameIP, port);
			socket.setSoTimeout(5000); // Timeout par défaut si on ne revoit
										// plus rien du serveur
			
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendRequest(String request) {
		System.out.println("Envoi de la requete "+request);
		out.println(request);
		System.out.println("Requete envoyee");
	}
	
	public void printReceivedMessageLbL() {
		System.out.println("Debut reception");
		String textString;
		try {
			while ((textString = in.readLine()) != null) {
				System.out.print(textString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\nFin reception");
	}
	
	public void receivedMessageToFile(File fileDest) {	
		try {
			String textString;
			BufferedWriter output = new BufferedWriter(new FileWriter(fileDest));
			
			while ((textString = in.readLine()) != null) {
				output.write(textString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void endClient() {
		try {
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
