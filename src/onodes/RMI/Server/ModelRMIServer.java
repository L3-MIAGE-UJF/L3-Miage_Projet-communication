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
import pnodes.monAppServer.ControllerMonAppServer;

public class ModelRMIServer extends UnicastRemoteObject implements ModelRMI,
		ModelRMIServerRemote<ModelRMIClientRemote> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 927689009392172109L;

	/**
	 * 
	 */
	// TODO Integrer liste Client plus optimisé
	private volatile ArrayList<ModelRMIClientRemote> clients;

	private ControllerMonAppServer controllerAppServer;

	public ModelRMIServer(ControllerMonAppServer controllerrmiserv)
			throws RemoteException {
		super();
		this.controllerAppServer = controllerrmiserv;
		launchServer("127.0.0.1");
		// InetAddress.getLocalHost().getHostAddress();
	}

	public ModelRMIServer() throws RemoteException {
		super();
		launchServer("127.0.0.1");
		// InetAddress.getLocalHost().getHostAddress();
	}

	public ModelRMIServer(String ip) throws RemoteException {
		super();
		launchServer(ip);
	}

	private void launchServer(String ip) {
		try {
			this.clients = new ArrayList<ModelRMIClientRemote>();

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

	@Override
	public Object invokeMethodOnControllerAppServer(String methodName,
			Class[] args) throws RemoteException {

		Object ret = null;

		Method method = null;

		try {
			method = controllerAppServer.getClass().getMethod(methodName, args);

			if (method == null) {
				System.err
						.println("Attention la methode "
								+ methodName
								+ " avec les parametres "
								+ args
								+ " n'existe pas sur le Controlleur de l'application Serveur");
			} else {
				ret = method.invoke(controllerAppServer, args);
			}
		} catch (NoSuchMethodException e) {
			e.getMessage();
		} catch (SecurityException e) {
			e.getMessage();
		} catch (IllegalAccessException e) {
			e.getMessage();
		} catch (IllegalArgumentException e) {
			e.getMessage();
		} catch (InvocationTargetException e) {
			e.getMessage();
		}

		return ret;
	}

	public void invokeMethodOnAllControllerAppClient(String methodName,
			Class[] args) {
		ModelRMIClientRemote currentClient;
		try {
			for (int i = 0; i < clients.size(); i++) {
				currentClient = clients.get(i);
				currentClient.invokeMethodOnControllerAppClient(methodName,
						args);
			}
		} catch (RemoteException e) {
			System.err.println("Remote Exception when RMI Server call method "
					+ methodName + " on modelRMIClientRemote");
			e.printStackTrace();
		}
	}

	public Object invokeMethodOnControllerAppClient(int idClient,
			String methodName, Class[] args) {
		Object ret = null;

		try {
			ModelRMIClientRemote currentClient;
			currentClient = clients.get(idClient);
			ret=currentClient.invokeMethodOnControllerAppClient(methodName, args);
		} catch (RemoteException e) {
			System.err.println("Remote Exception when RMI Server call method "
					+ methodName + " on modelRMIClientRemote");
			e.printStackTrace();
		}
		
		return ret;
	}

	@Override
	public String getInfoServer() throws RemoteException {
		return "Retour ModelRMIServer UID=" + serialVersionUID;
	}

	protected void addClient(ModelRMIClientRemote client) {
		this.clients.add(client);
	}

	@Override
	public void registerClient(ModelRMIClientRemote client)
			throws RemoteException {
		addClient(client);
		System.out.println("ModelRMIServer UID=" + serialVersionUID
				+ " : New client registered : " + client.getInfoClient());
		this.invokeMethodOnControllerAppServer("actionOnClientRegistration",
				new Class[] { ModelRMIClientRemote.class });
	}
}
