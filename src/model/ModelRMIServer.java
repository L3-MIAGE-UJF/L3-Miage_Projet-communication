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

import controler.ControlerRMIServer;
import controler.ControlerRMIClient;

public class ModelRMIServer extends UnicastRemoteObject implements ControlerRMIServer, Model {

	private static final long serialVersionUID = -3680509240396379710L;

	private volatile ControlerRMIClient cl;
	
	public ModelRMIServer() throws RemoteException {
		super();

		try {
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
	
	@Override
	public String getInfoServer() throws RemoteException {
		return "Retour ModelRMIServer UID="+serialVersionUID;
	}

	@Override
	public void regClient(ControlerRMIClient cl) throws RemoteException {
		this.cl=cl;
		System.out.println("ModelRMIServer UID="+serialVersionUID+" : regClient() : Chaine Recue "+cl.getInfoClient());
	}
}
