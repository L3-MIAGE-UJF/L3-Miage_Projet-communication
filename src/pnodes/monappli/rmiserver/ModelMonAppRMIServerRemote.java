package pnodes.monappli.rmiserver;

import java.rmi.RemoteException;

import onodes.RMI.Server.ModelRMIServerRemote;
import pnodes.monappli.rmiclient.ModelMonAppRMIClientRemote;

public interface ModelMonAppRMIServerRemote extends ModelRMIServerRemote<ModelMonAppRMIClientRemote> {
	public String methodeserveur() throws RemoteException;
}
