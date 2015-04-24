package model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.AccessControlException;

import controler.ControlerRMIClient;
import controler.ControlerRMIServer;

public class ModelRMIClient extends UnicastRemoteObject implements ControlerRMIClient, Model {

	private static final long serialVersionUID = 70109437196450691L;

	public ModelRMIClient() throws RemoteException {
		super();
		//ou super(0) ou UnicastRemoteObject.exportObject(this, 0); pas nécessaire car on étend déja UnicastRemoteObject 
		
		try {
			System.out.println("ModelRMIClient UID="+serialVersionUID+" : Lancement du client");
			
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			
			Remote r = Naming.lookup("rmi://127.0.0.1/testRMIserver");

			if (r instanceof ControlerRMIServer) {
				String s = ((ControlerRMIServer) r).getInfoServer();
				System.out.println("ModelRMIClient UID="+serialVersionUID+" : chaine renvoyee = " + s);
				
				ControlerRMIServer serv = (ControlerRMIServer) r;
				
				this.regOnServer(serv);
			}
			else { System.out.println("ModelRMIClient UID="+serialVersionUID+" : Instance incorrecte"); }
		} catch (RemoteException e) {
			System.err.println(e.getMessage());
		} catch (MalformedURLException e) {
			System.err.println(e.getMessage());
		} catch (AccessControlException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ModelRMIClient UID="+serialVersionUID+" : Fin du client");
	}
	
	@Override
	public String getInfoClient() throws RemoteException {
		System.out.println("ModelRMIClient UID="+serialVersionUID+" Server call me !");
		return "Retour ModelRMIClient UID="+serialVersionUID;
	}

	public void regOnServer(ControlerRMIServer remoteServer) {
		try {
			remoteServer.regClient(this);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
