package pnodes.monAppClient;

import java.rmi.RemoteException;

import onodes.Controller;

/**
 * @author groupe1
 *
 */
public class ControllerMonAppClient extends Controller<ModelMonAppClient, ViewMonAppClient> {

	/** Cree un controleur qui permet d'acceder au modele et a la vue selon le modele MVC.
	 * @throws RemoteException
	 */
	public ControllerMonAppClient() throws RemoteException {
		this.model = new ModelMonAppClient(this);
		this.view = new ViewMonAppClient();
	}
	
	/**
	 * Recupere le resultat de la methode testAppServer du serveur et l'affiche.
	 * Permet de tester invokeMethodOnControllerAppServer.
	 */
	public void startTEST() {
		String testretour = (String) model.invokeMethodOnControllerAppServer("testAppServer", new Class[] {}, new Object[] {});
		System.out.println(testretour);
	}
	
	/** Renvoie un String pour tester un appel de methode du serveur au client.
	 * @return Un String.
	 */
	public String testAppClient() {
		return "retour methode de test sur client";
	}
}
