package pnodes.monAppServer;

import onodes.Model;
import onodes.RMI.Server.ControllerRMIServer;
import onodes.RMI.Server.ModelRMIServer;

import java.rmi.RemoteException;
import java.util.Observable;

public class ModelMonAppServer extends Observable implements Model {

	private ControllerRMIServer crmiserv;
	//private ModelMonAppRMIServerRemote remoteMod;
	
	private String titre = "Origin";
	private int compteur = 0;
	
	public ModelMonAppServer(ControllerMonAppServer cmappserv) throws RemoteException {
		crmiserv= new ControllerRMIServer(cmappserv);
	}
	
	/*
	public ModelMonApp(ViewMonApp view) {
		this.addObserver(view);
	}
	*/
	/*
	public void traitementActionBouton() {
		System.out.println("Traitement de l'action du bouton");
		titre="nouveau string";
		setChanged();
		notifyObservers();
	}
	
	public void traitementActionRemoteBouton() {
		try {
			titre=remoteMod.methodeserveur();
		} catch (RemoteException | NullPointerException e) {
			e.printStackTrace();
		}
		setChanged();
		notifyObservers();
	}
	*/
	public String getTitre() {
		compteur++;
		return titre+" "+compteur;
	}
}
