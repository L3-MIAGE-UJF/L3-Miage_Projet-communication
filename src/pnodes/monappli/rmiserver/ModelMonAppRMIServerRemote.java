package pnodes.monappli.rmiserver;

import java.rmi.RemoteException;

import onodes.RMI.Server.ModelRMIServerRemote;

public interface ModelMonAppRMIServerRemote extends ModelRMIServerRemote {
	public String methodeserveur() throws RemoteException;
}
