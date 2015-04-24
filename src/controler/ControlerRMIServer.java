package controler;

import java.rmi.RemoteException;

/*
 * Besoin de conserver la même architecture de package dans Le serveur comme le client
 * afin que les classes puissent être trouvé lors du Naming.lookup()
 */
public interface ControlerRMIServer extends ControlerRemote {
	public String getInfoServer() throws RemoteException;

	void regClient(ControlerRMIClient cl) throws RemoteException;
}
