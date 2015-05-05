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
	 * 
	 */
	private ControllerRMIClient<ControllerAppChatClient> cRMIc;
	/**
	 * 
	 */
	private ControllerData controller;
	/**
	 * 
	 */
	private String list_user;
	
	/**
	 * @param controllerAppClient
	 * @throws RemoteException
	 */
	public ModelAppChatClient(ControllerAppChatClient controllerAppClient) throws RemoteException {
		cRMIc = new ControllerRMIClient<ControllerAppChatClient>(controllerAppClient, "152.77.82.74"); // A definir ip du serveur
		controller = new ControllerData();
	}

	/**
	 * @param methodName
	 * @param cArgs
	 * @param oArgs
	 * @return
	 */
	public Object invokeMethodOnControllerAppServer(String methodName, Class[] cArgs, Object[] oArgs) {
		return cRMIc.invokeMethodOnControllerAppServer(methodName, cArgs, oArgs);
	}
	
	/**
	 * @param str
	 */
	public void processingActionButton(String str) {	
		controller = new ControllerData(str);
		controller.addUser(str);
		cRMIc.invokeMethodOnControllerAppServer("addUser", new Class[] {String.class}, new Object[]{str});
		
	}
	
	/**
	 * @param str
	 */
	public void processingActionRemoteButton(String str) {
		try {
			cRMIc.invokeMethodOnControllerAppServer("addMessage", new Class[] {String.class, this.controller.getCurrentUser().getClass()}, new Object[]{str, this.controller.getCurrentUser()});
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public void majDiscussion(){
		setChanged();
		notifyObservers(controller.getDiscussion());
	}
	
	/**
	 * 
	 */
	public void majUtilisateur(){
		setChanged();
		notifyObservers(list_user);
	}
	
	/**
	 * @param str
	 * @param user
	 */
	public void addMessage (String str, GenericUser user){ 
    	GenericMessage<GenericUser, TextContent> message = new GenericMessage<GenericUser, TextContent>(user, new TextContent(str));
		controller.addMessage(message);
		majDiscussion();
	}
	
	/**
	 * @param user
	 */
	public void addUser (String user){
		list_user = user;
		majUtilisateur();
	}
}
