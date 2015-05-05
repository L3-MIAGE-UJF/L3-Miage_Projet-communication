package pnodes.monAppServerGeneric.rmiserver;

import java.rmi.RemoteException;
import onodes.RMI.ServerGeneric.ModelRMIServerGeneric;
import pnodes.monAppClientGeneric.rmiclient.ModelMonAppRMIClientRemote;

/**
 * @author groupe1
 *
 */
public class ModelMonAppRMIServer extends
		ModelRMIServerGeneric<ModelMonAppRMIServerRemote, ModelMonAppRMIClientRemote>
		implements ModelMonAppRMIServerRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4780327763814969334L;

	/**
	 * @throws RemoteException
	 */
	public ModelMonAppRMIServer() throws RemoteException {
		super();
	}

	/**
	 * @param ip
	 * @throws RemoteException
	 */
	public ModelMonAppRMIServer(String ip) throws RemoteException {
		super(ip);
	}

	@Override
	public String methodeserveur() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void actionOnClientRegistration(ModelMonAppRMIClientRemote client) {
		/*
		 * Complétez le code ici
		 */
		this.callMethodOnAllClients(client.getClass() ,"mamethodealacon", new Class[] {});
	}
}