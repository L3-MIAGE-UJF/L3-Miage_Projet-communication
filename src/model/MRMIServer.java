package model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.security.AccessControlException;
import java.util.ArrayList;

public class MRMIServer extends UnicastRemoteObject implements MRMI, MRMIServerRemote {
	/**
	 * 
	 */
	private static final long serialVersionUID = 927689009392172109L;

	/**
	 * 
	 */
	// TODO Integrer liste Client Hasmap plus optimisé
	private volatile ArrayList<MRMIClientRemote> clients;
	
	public MRMIServer() throws RemoteException {
		super();
		launchServer("127.0.0.1");
		//InetAddress.getLocalHost().getHostAddress();
	}
	
	public MRMIServer(String ip) throws RemoteException {
		super();
		launchServer(ip);
	}
	/**
	 * 
	 * @param ip
	 */
	private void launchServer(String ip) {
		try {
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
	
	private void addClient(MRMIClientRemote client) {
		clients.add(client);
	}
	
	private MRMIClientRemote getClient(int num) {
		return clients.get(num);
	}
	
	@Override
	public String getInfoServer() throws RemoteException {
		return "Retour ModelRMIServer UID="+serialVersionUID;
	}

	@Override
	public void registerClient(MRMIClientRemote client) throws RemoteException {
		addClient(client);
		System.out.println("ModelRMIServer UID="+serialVersionUID+" : New client registered : "+client.getInfoClient());
	}
}
