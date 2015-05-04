package pnodes.monappli.rmiclient;

import java.rmi.RemoteException;

import onodes.RMI.Client.ModelRMIClient;
import pnodes.monappli.rmiserver.ModelMonAppRMIServerRemote;

public class ModelMonAppRMIClient extends
		ModelRMIClient<ModelMonAppRMIServerRemote> implements
		ModelMonAppRMIClientRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6077450206617157617L;

	public ModelMonAppRMIClient() throws RemoteException {
		super();
	}

	public ModelMonAppRMIClient(String ip) throws RemoteException {
		super(ip);
	}

	@Override
	public void mamethodealacon() {
		try {
			System.out.println(this.serv.methodeserveur());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Coucou je suis le client");
	}

}
