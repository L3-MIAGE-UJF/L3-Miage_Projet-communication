package pnodes.monAppServer;

import java.rmi.RemoteException;

import onodes.Controller;

public class ControllerMonAppServer extends Controller<ModelMonAppServer, ViewMonAppServer> {

	public ControllerMonAppServer() throws RemoteException {
		this.model = new ModelMonAppServer(this);
		this.view = new ViewMonAppServer();
	}

	public ControllerMonAppServer(ModelMonAppServer model, ViewMonAppServer view) {
		super(model, view);
	}
	
	public String testAppServer() {
		return "retour methode de test sur serveur";
	}
	
	public void startTESTAll() {
		model.invokeMethodOnAllControllerAppClient("testAppClient", new Class[] {});
	}
	
	public Object startTESTOne(int id) {
		return model.invokeMethodOnControllerAppClient(id, "testAppClient", new Class[] {});
	}
}
