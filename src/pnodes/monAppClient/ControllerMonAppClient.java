package pnodes.monAppClient;

import java.rmi.RemoteException;

import onodes.Controller;

public class ControllerMonAppClient extends Controller<ModelMonAppClient, ViewMonAppClient> {

	public ControllerMonAppClient() throws RemoteException {
		this.model = new ModelMonAppClient(this);
		this.view = new ViewMonAppClient();
	}
	
	public void startTEST() {
		String testretour = (String) model.invokeMethodOnControllerAppServer("testAppServer", new Class[] {}, new Object[] {});
		System.out.println(testretour);
	}
	
	public String testAppClient() {
		return "retour methode de test sur client";
	}
}
