package pnodes.monappli.rmiclient;

import java.rmi.RemoteException;

import onodes.RMI.Client.ControllerRMIClient;
import pnodes.monappli.rmiserver.ModelMonAppRMIServerRemote;

public class ControllerMonAppRMIClient extends
		ControllerRMIClient<ModelMonAppRMIServerRemote, ModelMonAppRMIClient, ViewMonAppRMIClient> {

	public ControllerMonAppRMIClient() throws RemoteException {
		super(new ModelMonAppRMIClient(), new ViewMonAppRMIClient());
	}

	public ControllerMonAppRMIClient(ModelMonAppRMIClient model,
			ViewMonAppRMIClient view) throws RemoteException {
		super(model, view);
	}
}
