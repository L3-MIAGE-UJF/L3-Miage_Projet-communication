package pnodes.AppChatClient;

import onodes.Model;
import onodes.RMI.Client.ControllerRMIClient;

import java.rmi.RemoteException;
import java.util.Observable;

import dataFramework.ControllerData;
import dataFramework.contents.TextContent;
import dataFramework.messages.GenericMessage;
import dataFramework.users.GenericUser;

/**
 * @author groupe1
 *
 */
public class ModelAppChatClient extends Observable implements Model {

	/**
	 * Le controleur permettant d'invoquer les methodes sur le serveur.
	 */
	private ControllerRMIClient<ControllerAppChatClient> cRMIc;
	/**
	 * Le controller servant a gerer les utilisateurs, discussions et messages en local
	 */
	private ControllerData controller;
	/**
	 * La liste des utilisateurs connecte dans la discussion.
	 */
	private String list_user;
	
	/** 
	 * Construit l'objet ModelAppChatClient avec l'adresse ip en dur.
	 * @param controllerAppClient Le controller du model.
	 * @throws RemoteException
	 */
	public ModelAppChatClient(ControllerAppChatClient controllerAppClient) throws RemoteException {
		cRMIc = new ControllerRMIClient<ControllerAppChatClient>(controllerAppClient, "152.77.82.218"); // A definir ip du serveur
		controller = new ControllerData();
	}

	/** 
	 * Invoque les methodes sur le serveur.
	 * @param methodName Le nom de la methode stocke sur le serveur.
	 * @param cArgs Les classes des parametres de la methode.
	 * @param oArgs Les parametres de la methode.
	 * @return Autorise le retour via la methode.
	 */
	public Object invokeMethodOnControllerAppServer(String methodName, Class[] cArgs, Object[] oArgs) {
		return cRMIc.invokeMethodOnControllerAppServer(methodName, cArgs, oArgs);
	}
	
	/** 
	 * Sauvegarde le nom d'utilisateur courant et demande au serveur de signaler l'apparition d'un nouvel utilisateur.
	 * @param str Le nom d'un utilisateur
	 */
	public void processingActionButton(String str) {	
		controller = new ControllerData(str);
		controller.addUser(str);
		cRMIc.invokeMethodOnControllerAppServer("addUser", new Class[] {String.class}, new Object[]{str});
		
	}
	
	/** 
	 * Demande au serveur d'ajouter un nouveau message a la discussion.
	 * @param str Le contenu du message.
	 */
	public void processingActionRemoteButton(String str) {
		try {
			cRMIc.invokeMethodOnControllerAppServer("addMessage", new Class[] {String.class, this.controller.getCurrentUser().getClass()}, new Object[]{str, this.controller.getCurrentUser()});
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * Notifie aux observer qu'ils doivent mettre � jour la discussion.
	 */
	public void majDiscussion(){
		setChanged();
		notifyObservers(controller.getDiscussion());
	}
	
	/** 
	 * Notifie aux observer qu'ils doivent mettre � jour la liste des utilisateurs.
	 */
	public void majUtilisateur(){
		setChanged();
		notifyObservers(list_user);
	}
	
	/** 
	 * Ajoute un message a la discussion.
	 * @param str Le contenu du message
	 * @param user l'utilisateur
	 */
	public void addMessage (String str, GenericUser user){ 
    	GenericMessage<GenericUser, TextContent> message = new GenericMessage<GenericUser, TextContent>(user, new TextContent(str));
		controller.addMessage(message);
		majDiscussion();
	}
	
	/** 
	 * Sauvegarde en local la liste des utilisateurs.
	 * @param user La chaine de caractere contenant les noms des utilisateurs
	 */
	public void addUser (String user){
		list_user = user;
		majUtilisateur();
	}
}
