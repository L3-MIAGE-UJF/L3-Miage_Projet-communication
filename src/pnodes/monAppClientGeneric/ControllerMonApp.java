package pnodes.monAppClientGeneric;

import java.rmi.RemoteException;

import onodes.Controller;

/**
 * 
 * Ce module constitue une application temoin client minimaliste pour l'etablissement
 * d'une connexion entre deux applications par RMI.
 * Ce avec la specificite chaque methode distante souhaitant etre appelle doivent etre
 * definies dans un module RMI Client Generique.
 * Plus de details dans : ControllerRMIClientGeneric
 * 
 * Le fonctionnement est tel que le developpeur doit s'inspirer ou ameliorer ce module
 * pour la creation de son application / module
 * 
 * @author groupe1
 *
 */
public class ControllerMonApp extends Controller<ModelMonApp, ViewMonApp> {

	/**
	 * @throws RemoteException
	 */
	public ControllerMonApp() throws RemoteException {
		this.model = new ModelMonApp();
		this.view = new ViewMonApp(this, this.model);
		this.model.addObserver(view);
	}

	/**
	 * @param model
	 * @param view
	 */
	public ControllerMonApp(ModelMonApp model, ViewMonApp view) {
		super(model, view);
	}

	/**
	 * 
	 */
	public void actionBouton() {
		System.out.println("Recuperation action lancement traitement");
		model.traitementActionBouton();
	}

	/**
	 * 
	 */
	public void actionBoutonRemote() {
		System.out.println("Recuperation action Serveur lancement traitement");
		model.traitementActionRemoteBouton();
	}
}
