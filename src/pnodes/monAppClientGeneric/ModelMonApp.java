package pnodes.monAppClientGeneric;

import onodes.Model;
import java.rmi.RemoteException;
import java.util.Observable;
import pnodes.monAppClientGeneric.rmiclient.ControllerMonAppRMIClient;
import pnodes.monAppServerGeneric.rmiserver.ModelMonAppRMIServerRemote;

/**
 * @author groupe1
 *
 */
public class ModelMonApp extends Observable implements Model {

	/**
	 * 
	 */
	private ControllerMonAppRMIClient cmapp;
	/**
	 * 
	 */
	private ModelMonAppRMIServerRemote remoteMod;
	
	private String titre = "Origin";
	private int compteur = 0;
	
	/**
	 * @throws RemoteException
	 */
	public ModelMonApp() throws RemoteException {
		try {
			cmapp=new ControllerMonAppRMIClient("152.77.82.218");

			remoteMod=cmapp.getmRMIServerRemote();
		}
		catch (NullPointerException e) {
			e.getMessage();
		}
	}
	
	/**
	 * 
	 */
	public void traitementActionBouton() {
		System.out.println("Traitement de l'action du bouton");
		titre="nouveau string";
		setChanged();
		notifyObservers();
	}
	
	/**
	 * 
	 */
	public void traitementActionRemoteBouton() {
		try {
			titre=remoteMod.methodeserveur();
		} catch (RemoteException | NullPointerException e) {
			e.printStackTrace();
		}
		setChanged();
		notifyObservers();
	}
	
	/**
	 * @return
	 */
	public String getTitre() {
		compteur++;
		return titre+" "+compteur;
	}
}
