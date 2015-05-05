package pnodes.AppChatServer;

import java.rmi.RemoteException;

import dataFramework.ControllerData;
import dataFramework.users.GenericUser;
import onodes.Controller;

/**
 * @author groupe1
 *
 */
public class ControllerAppChatServer extends Controller<ModelAppChatServer, ViewAppChatServer> {

	/**
	 * 
	 */
	private ControllerData controller;
	
	/**
	 * @throws RemoteException
	 */
	public ControllerAppChatServer() throws RemoteException {
		this.model = new ModelAppChatServer(this);
		this.view = new ViewAppChatServer();
		controller =new ControllerData();
	}

	/**
	 * @param model
	 * @param view
	 */
	public ControllerAppChatServer(ModelAppChatServer model, ViewAppChatServer view) {
		super(model, view);
	}
	
	/**
	 * @param body
	 * @param user
	 */
	public void addMessage(String body, GenericUser user){
		model.invokeMethodOnAllControllerAppClient("addMessage", new Class[] {String.class, GenericUser.class}, new Object[] {body,user});
	}
	
	/**
	 * @param user
	 */
	public void addUser(String user){
		controller.addUser(user);
		model.invokeMethodOnAllControllerAppClient("addUser", new Class[] {String.class}, new Object[] {controller.showUsers()});
	}
}
