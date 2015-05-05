package onodes.RMI.Server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Enumeration;

import onodes.Controller;
import onodes.RMI.ModelRMI;
import onodes.RMI.Client.ModelRMIClientRemote;

public class ModelRMIServer<C extends Controller> extends UnicastRemoteObject implements ModelRMI,
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

	private C controllerAppServer;

	public ModelRMIServer(C controllerrmiserv)
			throws RemoteException {
		super();
		this.controllerAppServer = controllerrmiserv;
		launchServer(getFirstNonLocalAdress());
		// InetAddress.getLocalHost().getHostAddress();
	}

	private String getFirstNonLocalAdress() {
		String ret = null;
	    Enumeration en;
		try {
			en = NetworkInterface.getNetworkInterfaces();
		    while (en.hasMoreElements()) {
		        NetworkInterface i = (NetworkInterface) en.nextElement();
		        for (Enumeration en2 = i.getInetAddresses(); en2.hasMoreElements();) {
		            InetAddress addr = (InetAddress) en2.nextElement();
		            if (!addr.isLoopbackAddress()) {
		                if (addr instanceof Inet4Address) {
		                    ret=addr.getHostAddress();
		                }
		            }
		        }
		    }
		} catch (SocketException e) {
			e.getMessage();
		}
	    return ret;
	}

	public ModelRMIServer(C controllerrmiserv, String ip) throws RemoteException {
		super();
		this.controllerAppServer = controllerrmiserv;
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
			Class[] cArgs, Object[] oArgs) throws RemoteException {

		Object ret = null;

		Method method = null;

		try {
			method = controllerAppServer.getClass()
					.getMethod(methodName, cArgs);

			if (method == null) {
				System.err
						.println("Attention la methode "
								+ methodName
								+ " avec les parametres "
								+ oArgs.toString()
								+ " n'existe pas sur le Controlleur de l'application Serveur");
			} else {
				ret = method.invoke(controllerAppServer, oArgs);
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
			Class[] cArgs, Object[] oArgs) {
		ModelRMIClientRemote currentClient;
		try {
			for (int i = 0; i < clients.size(); i++) {
				currentClient = clients.get(i);
				currentClient.invokeMethodOnControllerAppClient(methodName,
						cArgs, oArgs);
			}
		} catch (RemoteException e) {
			System.err.println("Remote Exception when RMI Server call method "
					+ methodName + " on modelRMIClientRemote");
			e.printStackTrace();
		}
	}

	public Object invokeMethodOnControllerAppClient(int idClient,
			String methodName, Class[] cArgs, Object[] oArgs) {
		Object ret = null;

		try {
			ModelRMIClientRemote currentClient;
			currentClient = clients.get(idClient);
			ret = currentClient.invokeMethodOnControllerAppClient(methodName,
					cArgs, oArgs);
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
				new Class[] { ModelRMIClientRemote.class },
				new Object[] { client });
	}
}
