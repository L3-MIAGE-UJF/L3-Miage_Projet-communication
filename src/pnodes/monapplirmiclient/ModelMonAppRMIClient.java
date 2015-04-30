package pnodes.monapplirmiclient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import onodes.RMI.ModelRMI;
import onodes.RMI.Client.ModelRMIClient;
import onodes.RMI.Client.ModelRMIClientRemote;

//public abstract class ModelRMIClient<MR extends ModelRMIClientRemote> extends UnicastRemoteObject implements ModelRMI, ModelRMIClientRemote 
public class ModelMonAppRMIClient extends ModelRMIClient<ModelMonAppRMIClientRemote> implements ModelMonAppRMIClientRemote {
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
	public String mamethodealacon() {
		// TODO Auto-generated method stub
		return null;
	}

}
