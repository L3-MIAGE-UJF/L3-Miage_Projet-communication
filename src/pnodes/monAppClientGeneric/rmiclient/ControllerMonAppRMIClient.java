package pnodes.monAppClientGeneric.rmiclient;

import java.rmi.RemoteException;

import onodes.RMI.ClientGeneric.ControllerRMIClientGeneric;
import pnodes.monAppServerGeneric.rmiserver.ModelMonAppRMIServerRemote;

public class ControllerMonAppRMIClient extends
		ControllerRMIClientGeneric<ModelMonAppRMIServerRemote, ModelMonAppRMIClient, ViewMonAppRMIClient> {

	public ControllerMonAppRMIClient() throws RemoteException {
		super(new ModelMonAppRMIClient(), new ViewMonAppRMIClient());
	}

	public ControllerMonAppRMIClient(ModelMonAppRMIClient model,
			ViewMonAppRMIClient view) throws RemoteException {
		super(model, view);
	}
}
