package pnodes.monAppServerGeneric.rmiserver;

import java.rmi.RemoteException;

import onodes.RMI.ServerGeneric.ModelRMIServerGenericRemote;
import pnodes.monAppClientGeneric.rmiclient.ModelMonAppRMIClientRemote;

public interface ModelMonAppRMIServerRemote extends ModelRMIServerGenericRemote<ModelMonAppRMIClientRemote> {
	public String methodeserveur() throws RemoteException;
}
