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
	 * 
	 */
	private ControllerAppChatClient controller;

	/**
	 * 
	 */
	private ViewFenetreLog log;
	/**
	 * 
	 */
	private ViewFenetreChat chat;
	/**
	 * 
	 */
	private boolean login = true;
	
	/**
	 * @param controller
	 */
	public ViewAppChatClient(ControllerAppChatClient controller) {
		this.controller=controller;
		this.chat = new ViewFenetreChat(controller,this);
		this.log = new ViewFenetreLog(controller,this);
	}
	
	
	
	/**
	 * @param evt
	 * @param str
	 */
	public void buttonActionLogin(java.awt.event.ActionEvent evt,String str) {
		this.controller.actionBoutonLogin(str);
		this.log.setVisible(false);
		this.chat.setVisible(true);
		this.login = false;
	}

	/**
	 * @param evt
	 * @param str
	 */
	public void buttonRemoteActionMessage(java.awt.event.ActionEvent evt,String str) {
		this.controller.actionBoutonRemoteMessage(str);
	}
	
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