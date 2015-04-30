package pnodes.monapplirmiclient;

import java.rmi.RemoteException;

import onodes.RMI.Client.ControllerRMIClient;

public class ControllerMonAppRMIClient extends ControllerRMIClient<ModelMonAppRMIClient, ViewMonAppRMIClient> {

	public ControllerMonAppRMIClient() throws RemoteException {
		this.model = new ModelMonAppRMIClient();
		this.view = new ViewMonAppRMIClient();
	}
	
	public ControllerMonAppRMIClient(ModelMonAppRMIClient model, ViewMonAppRMIClient view)
			throws RemoteException {
		super(model, view);
	}

}
