package pnodes.monappli.rmiclient;

import java.rmi.RemoteException;

import onodes.RMI.Client.ModelRMIClientRemote;

public interface ModelMonAppRMIClientRemote extends ModelRMIClientRemote {
	public String mamethodealacon() throws RemoteException;
}