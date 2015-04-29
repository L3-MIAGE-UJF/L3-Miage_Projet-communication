package view;

import java.rmi.RemoteException;

public interface VRMIServer extends VRMI {
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
	void regClient(VRMIClient cl) throws RemoteException;
}
