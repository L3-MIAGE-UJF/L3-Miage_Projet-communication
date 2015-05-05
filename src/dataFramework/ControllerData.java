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
	 * 
	 */
	private GenericUser currentUser = null;
	
	/**
	 * @param str
	 */
	public ControllerData(String str){
		super();
		this.discussion = new GenericDiscussion();
		this.currentUser = new GenericUser(str);
	}
	

	/**
	 * 
	 */
	public ControllerData() {
		super();
		this.discussion = new GenericDiscussion();
	}
	
	/**
	 * @param str
	 */
	public void addUser(String str){
		this.discussion.addUser(str);
	}
	
	/**
	 * @param message
	 */
	public void addMessage(GenericMessage message){
		this.discussion.add(message);
	}
	
	/**
	 * @return
	 */
	public GenericDiscussion getDiscussion(){
		return this.discussion;
	}
	
	/**
	 * @return
	 */
	public GenericUser getLastUser(){
		return this.discussion.getUsers().getUser(this.discussion.getUsers().size()-1);
	}
	
	/**
	 * @return
	 */
	public String showUsers() {
		String result = "";
		for(int i = 0; i < this.discussion.getUsers().size(); i++){
			result += this.discussion.getUsers().getUser(i).getLogin() + "\n";
		}
		return result;
	}
	
	public String toString() {
		return this.discussion.toString();
	}
	
	/**
	 * @return
	 */
	public GenericUser getCurrentUser(){
		return this.currentUser;
	}
	
	
}
