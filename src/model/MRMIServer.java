package model;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.security.AccessControlException;

public class MRMIServer extends UnicastRemoteObject implements MRMI, MRMIServerRemote {
	/**
	 * 
	 */
	private static final long serialVersionUID = 927689009392172109L;

	/**
	 * 
	 */
	private volatile MRMIClientRemote client;
	
	public MRMIServer() throws RemoteException {
		super();
		
		try {
			System.out.println("=================================================================");
			System.out.println("ModelRMIServer UID="+serialVersionUID+" : Création du serveur RMI");
			LocateRegistry.createRegistry(1099);

			System.out.println("ModelRMIServer UID="+serialVersionUID+" : Mise en place du Security Manager ...");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}

			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress()	+ "/testRMIserver";
			System.out.println("ModelRMIServer UID="+serialVersionUID+" : Enregistrement de l'objet avec l'url : " + url);

			Naming.rebind(url, this);

			System.out.println("ModelRMIServer UID="+serialVersionUID+" : Serveur lancé");
			System.out.println("=================================================================");
		} catch (RemoteException e) {
			System.err.println(e.getMessage());
		} catch (MalformedURLException e) {
			System.err.println(e.getMessage());
		} catch (UnknownHostException e) {
			System.err.println(e.getMessage());
		} catch (AccessControlException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected MRMIServer(int port) throws RemoteException {
		super(port);
	}

	@Override
	public String getInfoServer() throws RemoteException {
		return "Retour ModelRMIServer UID="+serialVersionUID;
	}

	@Override
	public void registerClient(MRMIClientRemote client) throws RemoteException {
		this.client=client;
		System.out.println("ModelRMIServer UID="+serialVersionUID+" : regClient() : Chaine Recue "+client.getInfoClient());
	}
}
