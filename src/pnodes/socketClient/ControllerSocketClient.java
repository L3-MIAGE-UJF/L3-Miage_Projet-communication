package pnodes.socketClient;

import java.io.File;

import onodes.Controller;

/**
 * Controlleur du module SocketClient
 * Ce Module a pour objectif d'etendre les apports du framework dans une optique d'échange avec d'autres
 * applications qui ne seraient pas developpes avec RMI. Des serveurs web par exemple.
 * Avec le fonctionnement en module du framework, cela est facile d'envisager une application chat utilisant RMI
 * pour se connecter sur d'autres applications avec le module RMI, mais également qu'elle puisse récupérer un
 * fichier venant d'un serveur web via des sockets.
 * 
 * 
 * Jeu de Test pour le module :
 *
 * hostnameorip = "google.fr" | "106.10.212.24" | "www-cache.ujf-grenoble.fr"
 * ControllerSocketClient test = new ControllerSocketClient(hostnameorip, 80);
 * test.sendRequest("GET /");
 * test.printReceivedMessageLbL();
 * test.endClient();
 * 		
 * @author groupe1
 *
 */
public class ControllerSocketClient extends Controller<ModelSocketClient, ViewSocketClient> {
	/**
	 * Constructeur du Controleur du module SocketClient
	 * Cela initialise la connexion à l'aide de socket sur le serveur avec le port souhaité
	 * 
	 * Ne Pas oublier d'appeller endClient() à la fin de l'utilisation de ce module
	 * 
	 * @param serverIporName l'adresse IP ou le HostName du serveur auquel nous souhaitont nous connecter
	 * @param port Numero du port sur lequel nous souhaitons nous connecter.
	 */
	public ControllerSocketClient(String serverIporName, int port) {
		model=new ModelSocketClient(serverIporName, port);
	}
	
	/**
	 * Envoi d'une requete au Serveur 
	 * @param request Requete en format String
	 */
	public void sendRequest(String request) {
		model.sendRequest(request);
	}
	
	/**
	 * Affichage en console ligne à ligne des
	 * informations reçues par le serveur.
	 */
	public void printReceivedMessageLbL() {
		model.printReceivedMessageLbL();
	}
	
	/**
	 * Exporte les informations reçues par le serveur dans un fichier
	 * @param fileDest
	 */
	public void receivedMessageToFile(File fileDest) {
		model.receivedMessageToFile(fileDest);
	}
	
	/**
	 * Cloture du client, fermeture des sockets
	 * Il est essentiel d'appeller cette fonction avant la fin de l'application
	 */
	public void endClient() {
		model.endClient();
	}
}
