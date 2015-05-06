package pnodes.monAppClientGeneric.rmiclient;

import java.rmi.RemoteException;

import onodes.RMI.ClientGeneric.ControllerRMIClientGeneric;
import pnodes.monAppServerGeneric.rmiserver.ModelMonAppRMIServerRemote;

/**
 * @author groupe1
 *
 */
public class ControllerMonAppRMIClient extends
		ControllerRMIClientGeneric<ModelMonAppRMIServerRemote, ModelMonAppRMIClient, ViewMonAppRMIClient> {

	/**
	 * @throws RemoteException
	 */
	public ControllerMonAppRMIClient(String ip) throws RemoteException {
		super(new ModelMonAppRMIClient(ip), new ViewMonAppRMIClient());
	}

	/**
	 * @param model
	 * @param view
	 * @throws RemoteException
	 */
	public ControllerMonAppRMIClient(ModelMonAppRMIClient model,
			ViewMonAppRMIClient view) throws RemoteException {
		super(model, view);
	}
}
