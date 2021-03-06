package onodes.RMI.ServerGeneric;

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
import java.util.Iterator;

import onodes.RMI.ModelRMI;
import onodes.RMI.ClientGeneric.ModelRMIClientGenericRemote;

/**
 * @author groupe1
 *
 * @param <MR>
 * @param <MC>
 */
public abstract class ModelRMIServerGeneric<MR extends ModelRMIServerGenericRemote, MC extends ModelRMIClientGenericRemote>
		extends UnicastRemoteObject implements ModelRMI, ModelRMIServerGenericRemote<MC> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 927689009392172109L;

	/**
	 * 
	 */
	// TODO Integrer liste Client plus optimisé
	private volatile ArrayList<MC> clients;
	
	/**
	 * @throws RemoteException
	 */
	public ModelRMIServerGeneric() throws RemoteException {
		super();
		launchServer("127.0.0.1");
		// InetAddress.getLocalHost().getHostAddress();
	}

	/**
	 * @param ip
	 * @throws RemoteException
	 */
	public ModelRMIServerGeneric(String ip) throws RemoteException {
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

	/**
	 * @param client
	 */
	protected void addClient(MC client) {
		this.clients.add(client);
	}

	/**
	 * @return
	 */
	protected ArrayList<MC> getAllClients() {
		return this.clients;
	}

	/**
	 * @param num
	 * @return
	 */
	protected ModelRMIClientGenericRemote getClient(int num) {
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

	/**
	 * @param client
	 */
	protected abstract void actionOnClientRegistration(MC client);

	/**
	 * @param clientClass
	 * @param methodName
	 * @param args
	 */
	protected void callMethodOnAllClients(Class<? extends ModelRMIClientGenericRemote> clientClass, String methodName, Class[] args) {
		System.out.println("call to all client");
		MC currentClient = null;

		Method method = null;
		
		try {
			method = clientClass.getMethod(methodName, args);
		} catch (NoSuchMethodException e) {
			e.getMessage();
		} catch	(SecurityException e) {
			e.getMessage();
		}
		
		for (int i=0; i<clients.size(); i++) {
			currentClient=clients.get(i);
				try {
					if (method==null) {
						System.out.println("echec et mat method");
					}
					
					if (currentClient==null) {
						System.out.println("echec et mat client");
					}
					
					if (args==null) {
						System.out.println("echec et mat args");
					}
					
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
