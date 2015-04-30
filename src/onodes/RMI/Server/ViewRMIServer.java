package onodes.RMI.Server;

import java.rmi.RemoteException;

import onodes.RMI.ViewRMI;
import onodes.RMI.Client.ViewRMIClient;

public interface ViewRMIServer extends ViewRMI {
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public String getInfoServer() throws RemoteException;

	/**
	 * 
	 * @param cl
	 * @throws RemoteException
	 */
	void regClient(ViewRMIClient cl) throws RemoteException;
}
