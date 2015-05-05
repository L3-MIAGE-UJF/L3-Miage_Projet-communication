package pnodes.AppChatClient;


import java.util.Observable;
import java.util.Observer;

import onodes.View;
import pnodes.AppChatClient.ControllerAppChatClient;
import pnodes.AppChatClient.ViewFenetreChat;
import pnodes.AppChatClient.ViewFenetreLog;

/**
 * @author groupe1
 *
 */
public class ViewAppChatClient implements View,Observer {

	/**
	 * Le controleur qui instancie la vue.
	 */
	private ControllerAppChatClient controller;

	/**
	 * La fenetre de login.
	 */
	private ViewFenetreLog log;
	/**
	 * La fenetre de chat.
	 */
	private ViewFenetreChat chat;
	/**
	 * Indique si la vue a deja recu la demande de connexion
	 */
	private boolean login = true;
	
	/**
	 * Construit l'objet ViewAppChatClient qui initialise les fenetres graphiques.
	 * @param controller 
	 */
	public ViewAppChatClient(ControllerAppChatClient controller) {
		this.controller=controller;
		this.chat = new ViewFenetreChat(controller,this);
		this.log = new ViewFenetreLog(controller,this);
	}
	
	
	
	/**
	 * Demande au controleur de reorienter la methode d'ajout d'utilisateur au modele.
	 * @param evt L'evenement d'ajout d'utilisateur.
	 * @param str La chaine de caractère représentant le nom de l'utilisateur.
	 */
	public void buttonActionLogin(java.awt.event.ActionEvent evt,String str) {
		this.controller.actionBoutonLogin(str);
		this.log.setVisible(false);
		this.chat.setVisible(true);
		this.login = false;
	}

	/**
	 * Demande au controleur de reorienter la methode d'envoie de message au modele.
	 * @param evt L'evenement d'envoie de message.
	 * @param str La chaine de caractère représentant le contenu d'un message.
	 */
	public void buttonRemoteActionMessage(java.awt.event.ActionEvent evt,String str) {
		this.controller.actionBoutonRemoteMessage(str);
	}
	
	/**
	 * Met à jour les fenetres graphiques en fonction de la nature des paramatres.
	 * @param o
	 * @param arg Objet correspondant a 
	 */
	public void update(Observable o, Object arg) {
		if(!login){
			try {
				if(arg.getClass() == Class.forName("dataFramework.discussion.GenericDiscussion")){ 
					this.chat.update(o,arg);				
				}
				else{
					this.chat.update_user(o,arg);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		else
		{
			this.chat.update_user(o, arg);
		}
	}
}