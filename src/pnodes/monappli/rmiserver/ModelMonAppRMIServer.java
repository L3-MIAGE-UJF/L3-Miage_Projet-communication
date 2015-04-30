package pnodes.monappli.rmiserver;

import java.rmi.RemoteException;

import onodes.RMI.Server.ModelRMIServer;

public class ModelMonAppRMIServer extends
		ModelRMIServer<ModelMonAppRMIServerRemote> implements
		ModelMonAppRMIServerRemote {

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
		return "coucou je suis le serveur";
	}

}
