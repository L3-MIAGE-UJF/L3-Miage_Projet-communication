package pnodes.AppChatClient;

import java.rmi.RemoteException;

import dataFramework.users.GenericUser;
import onodes.Controller;

/**
 * 
 * Ce module constitue une application temoin client minimaliste pour l'etablissement d'un
 * chat entre plusieurs application clients par le biais d'un serveur.
 * 
 * Le fonctionnement est tel que le developpeur peut s'inspirer ou ameliorer ce module
 * pour la creation de son application chat.
 * 
 * @author groupe1
 *
 */
public class ControllerAppChatClient extends Controller<ModelAppChatClient, ViewAppChatClient> {

	/**
	 * @throws RemoteException
	 */
	public ControllerAppChatClient() throws RemoteException {
		this.model = new ModelAppChatClient(this);
		this.view = new ViewAppChatClient(this);
		this.model.addObserver(view);
	}

	/** 
	 * Indique au modele la connexion de l'application au chat
	 * @param str Le nom de l'utilisateur
	 */
	public void actionBoutonLogin(String str) {
		System.out.println("Recuperation action lancement traitement");
		model.processingActionButton(str);
	}

	/** 
	 * Indique au modele que l'application client rajoute un message a la discussion
	 * @param str Le contenu d'une nouveau message
	 */
	public void actionBoutonRemoteMessage(String str) {
		System.out.println("Recuperation action Serveur lancement traitement");
		model.processingActionRemoteButton(str);
	}
	
	/** 
	 * Demande au modele de rajouter un message dans la discussion.
	 * @param body Le contenu d'un message
	 * @param user L'utilisateur envoyant le message
	 */
	public void addMessage(String body, GenericUser user){
		model.addMessage(body, user);
	}
	
	/** 
	 * Demande au modele de rajouter un utilisateur dans la liste des utilisateurs.
	 * @param user Le nom du nouvel utilisateur
	 */
	public void addUser(String user){
		model.addUser(user);
	}
}
