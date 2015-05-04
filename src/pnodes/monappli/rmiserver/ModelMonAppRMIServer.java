package pnodes.monappli.rmiserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import onodes.RMI.ModelRMI;
import onodes.RMI.Client.ModelRMIClientRemote;
import onodes.RMI.Server.ModelRMIServer;
import onodes.RMI.Server.ModelRMIServerRemote;
import pnodes.monappli.rmiclient.ModelMonAppRMIClientRemote;

public class ModelMonAppRMIServer extends
		ModelRMIServer<ModelMonAppRMIServerRemote, ModelMonAppRMIClientRemote>
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
		this.callMethodOnAllClients("mamethodealacon", new Class[] {});
	}
}
