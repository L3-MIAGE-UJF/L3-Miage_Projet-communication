package pnodes.monAppClient;

import java.rmi.RemoteException;

import onodes.Controller;

public class ControllerMonAppClient extends Controller<ModelMonAppClient, ViewMonAppClient> {

	public ControllerMonAppClient() throws RemoteException {
		this.model = new ModelMonAppClient(this);
		this.view = new ViewMonAppClient();
	}

	public ControllerMonAppClient(ModelMonAppClient model, ViewMonAppClient view) {
		super(model, view);
	}
	
	public void startTEST() {
		String testretour = (String) model.invokeMethodOnControllerAppServer("testAppServer", new Class[] {});
		System.out.println(testretour);
	}
	
	public String testAppClient() {
		return "retour methode de test sur client";
	}
}
