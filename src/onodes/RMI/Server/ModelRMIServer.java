package onodes.RMI.Server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

public abstract class ModelRMIServer<MR extends ModelRMIServerRemote, MC extends ModelRMIClientRemote>
		extends UnicastRemoteObject implements ModelRMI, ModelRMIServerRemote<MC> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 927689009392172109L;

	/**
	 * 
	 */
	// TODO Integrer liste Client plus optimisé
	private volatile ArrayList<MC> clients;
	
	public ModelRMIServer() throws RemoteException {
		super();
		launchServer("127.0.0.1");
		// InetAddress.getLocalHost().getHostAddress();
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
			this.clients = new ArrayList<MC>();

			System.out
					.println("=================================================================");
			System.out.println("ModelRMIServer UID=" + serialVersionUID
					+ " : Création du serveur RMI");
			LocateRegistry.createRegistry(1099);

			System.out.println("ModelRMIServer UID=" + serialVersionUID
					+ " : Mise en place du Security Manager ...");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}

			String url = "rmi://" + ip + "/testRMIserver";
			System.out.println("ModelRMIServer UID=" + serialVersionUID
					+ " : Enregistrement de l'objet avec l'url : " + url);

			Naming.rebind(url, this);

			System.out.println("ModelRMIServer UID=" + serialVersionUID
					+ " : Serveur lancé");
			System.out
					.println("=================================================================");
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

	protected void addClient(MC client) {
		this.clients.add(client);
	}

	protected ArrayList<MC> getAllClients() {
		return this.clients;
	}

	protected ModelRMIClientRemote getClient(int num) {
		return clients.get(num);
	}

	@Override
	public String getInfoServer() throws RemoteException {
		return "Retour ModelRMIServer UID=" + serialVersionUID;
	}

	@Override
	public void registerClient(MC client) throws RemoteException {
		addClient(client);
		System.out.println("ModelRMIServer UID=" + serialVersionUID
				+ " : New client registered : " + client.getInfoClient());
		actionOnClientRegistration(client);
	}

	protected abstract void actionOnClientRegistration(MC client);

	protected void callMethodOnAllClients(String methodName, Class[] args) {
		System.out.println("");
		MC currentClient = null;
		Class<? extends ModelRMIClientRemote> clientClass = currentClient.getClass();
		
		Method method = null;
		
		try {
			method = clientClass.getDeclaredMethod(methodName, args);
		} catch (NoSuchMethodException e) {
			e.getMessage();
		} catch	(SecurityException e) {
			e.getMessage();
		}
		
		for (int i=0; i<clients.size(); i++) {
			currentClient=clients.get(i);
				try {
					method.invoke(currentClient, args);
				} catch (IllegalAccessException e) {
					e.getMessage();
				} catch (IllegalArgumentException e) {
					e.getMessage();
				} catch (InvocationTargetException e) {
					e.getMessage();
				}
		}
	}
}
