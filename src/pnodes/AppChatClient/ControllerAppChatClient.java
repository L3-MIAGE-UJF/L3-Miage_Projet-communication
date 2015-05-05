package pnodes.AppChatClient;

import java.rmi.RemoteException;

import dataFramework.users.GenericUser;
import onodes.Controller;

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
	 * @param str
	 */
	public void actionBoutonLogin(String str) {
		System.out.println("Recuperation action lancement traitement");
		model.processingActionButton(str);
	}

	/**
	 * @param str
	 */
	public void actionBoutonRemoteMessage(String str) {
		System.out.println("Recuperation action Serveur lancement traitement");
		model.processingActionRemoteButton(str);
	}
	
	/**
	 * @param body
	 * @param user
	 */
	public void addMessage(String body, GenericUser user){
		model.addMessage(body, user);
	}
	
	public void addUser(String user){
		model.addUser(user);
	}
}
