package pnodes.monAppServer;

import java.rmi.RemoteException;

import onodes.Controller;

/**
 * 
 * Ce module constitue une application temoin serveur minimaliste pour l'etablissement
 * d'une connexion entre deux applications par RMI.
 * Ce avec la specificite que l'appel de methode distante se fait par l'usage de 
 * invokeMethodOnAllControllerAppClient() ou one . Ceci est realisable grace a l'instanciation 
 * du module RMIServer non generique. Plus de details dans : ControllerRMIServer
 * 
 * Le fonctionnement est tel que le developpeur doit s'inspirer ou ameliorer ce module
 * pour la creation de son application / module
 * 
 * 
 * @author groupe1
 *
 */
public class ControllerMonAppServer extends Controller<ModelMonAppServer, ViewMonAppServer> {

	/**
	 * @throws RemoteException
	 */
	public ControllerMonAppServer() throws RemoteException {
		this.model = new ModelMonAppServer(this);
		this.view = new ViewMonAppServer();
	}
	
	/**
	 * @return
	 */
	public String testAppServer() {
		return "retour methode de test sur serveur";
	}
	
	/**
	 * 
	 */
	public void startTESTAll() {
		model.invokeMethodOnAllControllerAppClient("testAppClient", new Class[] {}, new Object[] {});
	}
	
	/**
	 * @param id
	 * @return
	 */
	public Object startTESTOne(int id) {
		return model.invokeMethodOnControllerAppClient(id, "testAppClient", new Class[] {}, new Object[] {});
	}
}
