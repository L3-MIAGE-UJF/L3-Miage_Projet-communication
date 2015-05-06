package pnodes.AppChatServer;

import java.rmi.RemoteException;

import dataFramework.ControllerData;
import dataFramework.users.GenericUser;
import onodes.Controller;

/**
 * 
 * Ce module constitue une application temoin serveur minimaliste pour l'etablissement d'un
 * chat entre plusieurs application clients par le biais d'un serveur.
 * 
 * Le fonctionnement est tel que le developpeur peut s'inspirer ou ameliorer ce module
 * pour la creation de son application chat.
 * 
 * @author groupe1
 *
 */
public class ControllerAppChatServer extends Controller<ModelAppChatServer, ViewAppChatServer> {

	/**
	 * 
	 */
	private ControllerData controller;
	
	/** Cree un controleur avec un modele et une vie.
	 * @throws RemoteException
	 */
	public ControllerAppChatServer() throws RemoteException {
		this.model = new ModelAppChatServer(this);
		this.view = new ViewAppChatServer();
		controller =new ControllerData();
	}

	/** Cree un controleur associe a un modele et une vue.
	 * @param model Le modele associe au controleur.
	 * @param view La vue associe au controleur.
	 */
	public ControllerAppChatServer(ModelAppChatServer model, ViewAppChatServer view) {
		super(model, view);
	}
	
	/** Signale a tous les utilisateurs d'ajouter un message.
	 * @param body Le contenu d'un message.
	 * @param user L'utilisateur postant le message.
	 */
	public void addMessage(String body, GenericUser user){
		model.invokeMethodOnAllControllerAppClient("addMessage", new Class[] {String.class, GenericUser.class}, new Object[] {body,user});
	}
	
	/** Signale a tous les utilisateurs d'ajouter un utilisateur a la liste.
	 * @param user Le nom du nouvel utilisateur.
	 */
	public void addUser(String user){
		controller.addUser(user);
		model.invokeMethodOnAllControllerAppClient("addUser", new Class[] {String.class}, new Object[] {controller.showUsers()});
	}
}
