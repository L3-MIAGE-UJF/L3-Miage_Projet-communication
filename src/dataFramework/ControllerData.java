package dataFramework;

import onodes.*;

import dataFramework.discussion.GenericDiscussion;
import dataFramework.messages.GenericMessage;
import dataFramework.users.GenericUser;

/**
 * @author groupe1
 *
 */
public class ControllerData extends Controller{

	/**
	 * 
	 */
	private GenericDiscussion discussion;
	/**
	 * L'utilisateur ayant cree l'application client.
	 */
	private GenericUser currentUser = null;
	
	/**
	 * Cree une nouvelle discussion avec un utilisateur pour l'application client.
	 * @param str Le nom de l'utilisateur courant.
	 */
	public ControllerData(String str){
		super();
		this.discussion = new GenericDiscussion();
		this.currentUser = new GenericUser(str);
	}
	

	/**
	 * Cree une nouvelle discussion
	 */
	public ControllerData() {
		super();
		this.discussion = new GenericDiscussion();
	}
	
	/**
	 * Rajoute un utilisateur a la discussion.
	 * @param str Le nom de l'utilisateur.
	 */
	public void addUser(String str){
		this.discussion.addUser(str);
	}
	
	/**
	 * Rajoute un message dans la discussion.
	 * @param message Le nouveau message.
	 */
	public void addMessage(GenericMessage message){
		this.discussion.add(message);
	}
	
	/** Recupere la discussion.
	 * @return La discussion.
	 */
	public GenericDiscussion getDiscussion(){
		return this.discussion;
	}
	
	/** Recupere le dernier utilisateur a s'etre connecte
	 * @return Le dernier utilisateur a s'etre connecte.
	 */
	public GenericUser getLastUser(){
		return this.discussion.getUsers().getUser(this.discussion.getUsers().size()-1);
	}
	
	/** Recupere la liste des utilisateurs.
	 * @return Les utilisateurs sous forme de String
	 */
	public String showUsers() {
		String result = "";
		for(int i = 0; i < this.discussion.getUsers().size(); i++){
			result += this.discussion.getUsers().getUser(i).getLogin() + "\n";
		}
		return result;
	}
	
	
	@Override
	public String toString() {
		return this.discussion.toString();
	}
	
	/** Recupere l'utilisateur courant.
	 * @return L'utilisateur courant.
	 */
	public GenericUser getCurrentUser(){
		return this.currentUser;
	}
	
	
}
