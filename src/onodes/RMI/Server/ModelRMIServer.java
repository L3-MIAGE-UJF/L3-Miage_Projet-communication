package onodes.RMI.Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.security.AccessControlException;
import java.util.ArrayList;

import onodes.RMI.ModelRMI;
import onodes.RMI.Client.ModelRMIClientRemote;

public class ModelRMIServer extends UnicastRemoteObject implements ModelRMI, ModelRMIServerRemote {
	/**
	 * 
	 */
	private static final long serialVersionUID = 927689009392172109L;

	/**
	 * 
	 */
	// TODO Integrer liste Client Hasmap plus optimisé
	private volatile ArrayList<ModelRMIClientRemote> clients;
	
	public ModelRMIServer() throws RemoteException {
		super();
		launchServer("127.0.0.1");
		//InetAddress.getLocalHost().getHostAddress();
	}
	
	public ModelRMIServer(String ip) throws RemoteException {
		super();
		launchServer(ip);
	}
	/**
	 * 
	 * @param ip
	 */
	private void launchServer(String ip) {
		try {
			this.clients = new ArrayList<ModelRMIClientRemote>();
			
			System.out.println("=================================================================");
			System.out.println("ModelRMIServer UID="+serialVersionUID+" : Création du serveur RMI");
			LocateRegistry.createRegistry(1099);

			System.out.println("ModelRMIServer UID="+serialVersionUID+" : Mise en place du Security Manager ...");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}

			String url = "rmi://"+ip+"/testRMIserver";
			System.out.println("ModelRMIServer UID="+serialVersionUID+" : Enregistrement de l'objet avec l'url : " + url);

			Naming.rebind(url, this);

			System.out.println("ModelRMIServer UID="+serialVersionUID+" : Serveur lancé");
			System.out.println("=================================================================");
		} catch (RemoteException e) {
			System.err.println(e.getMessage());
		} catch (MalformedURLException e) {
			System.err.println(e.getMessage());
		} catch (AccessControlException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addClient(ModelRMIClientRemote client) {
		this.clients.add(client);
	}
	
	private ModelRMIClientRemote getClient(int num) {
		return clients.get(num);
	}
	
	@Override
	public String getInfoServer() throws RemoteException {
		return "Retour ModelRMIServer UID="+serialVersionUID;
	}

	@Override
	public void registerClient(ModelRMIClientRemote client) throws RemoteException {
		this.addClient(client);
		System.out.println("ModelRMIServer UID="+serialVersionUID+" : New client registered : "+client.getInfoClient());
	}
	
	public void upa(String test) {
		System.out.println("executee !");
		try {
			System.out.println(clients.get(0).getInfoClient());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
