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
	 * @param ip
	 * @throws RemoteException
	 */
	public ModelMonAppRMIServer(String ip) throws RemoteException {
		super(ip);
	}

	@Override
	public String methodeserveur() throws RemoteException {
		return "Je suis le serveur";
	}

	@Override
	protected void actionOnClientRegistration(ModelMonAppRMIClientRemote client) {
		/*
		 * Completez / modifiez le code
		 */
		//this.callMethodOnAllClients(client.getClass() ,"clientRegistered", new Class[] {});
	}
}
