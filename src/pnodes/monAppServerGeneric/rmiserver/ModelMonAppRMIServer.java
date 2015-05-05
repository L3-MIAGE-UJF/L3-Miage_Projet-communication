package pnodes.monAppServerGeneric.rmiserver;

import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import onodes.RMI.ModelRMI;
import onodes.RMI.ClientGeneric.ModelRMIClientGenericRemote;
import onodes.RMI.ServerGeneric.ModelRMIServerGeneric;
import onodes.RMI.ServerGeneric.ModelRMIServerGenericRemote;
import pnodes.monAppClientGeneric.rmiclient.ModelMonAppRMIClientRemote;

public class ModelMonAppRMIServer extends
		ModelRMIServerGeneric<ModelMonAppRMIServerRemote, ModelMonAppRMIClientRemote>
		implements ModelMonAppRMIServerRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4780327763814969334L;

	public ModelMonAppRMIServer() throws RemoteException {
		super();
	}

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
