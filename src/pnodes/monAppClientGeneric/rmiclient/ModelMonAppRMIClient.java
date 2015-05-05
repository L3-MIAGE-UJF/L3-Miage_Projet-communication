package pnodes.monAppClientGeneric.rmiclient;

import java.rmi.RemoteException;

import onodes.RMI.ClientGeneric.ModelRMIClientGeneric;
import pnodes.monAppServerGeneric.rmiserver.ModelMonAppRMIServerRemote;

/**
 * @author groupe1
 *
 */
public class ModelMonAppRMIClient extends
		ModelRMIClientGeneric<ModelMonAppRMIServerRemote> implements
		ModelMonAppRMIClientRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6077450206617157617L;

	/**
	 * @throws RemoteException
	 */
	public ModelMonAppRMIClient() throws RemoteException {
		super();
	}

	/**
	 * @param ip
	 * @throws RemoteException
	 */
	public ModelMonAppRMIClient(String ip) throws RemoteException {
		super(ip);
	}

	@Override
	public void mamethodetest() {
		try {
			System.out.println(this.serv.methodeserveur());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		System.out.println("Coucou je suis le client");
	}
}
