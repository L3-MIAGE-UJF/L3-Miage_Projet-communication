package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * Besoin de conserver la même architecture de package dans Le serveur comme le client
 * afin que les classes puissent être trouvé lors du Naming.lookup()
 */

/**
*
* DO NOT EDIT THIS FILE IT BELONG TO THE FRAMEWORK
* @author groupe1
*
*/
public interface MRMIServerRemote extends Remote {
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public String getInfoServer() throws RemoteException;

	/**
	 * 
	 * @param client
	 * @throws RemoteException
	 */
	void registerClient(MRMIClientRemote client) throws RemoteException;
}