package pnodes.monAppClient;

import java.rmi.RemoteException;

import onodes.Controller;

/**
 * @author groupe1
 *
 */
public class ControllerMonAppClient extends Controller<ModelMonAppClient, ViewMonAppClient> {

	/**
	 * @throws RemoteException
	 */
	public ControllerMonAppClient() throws RemoteException {
		this.model = new ModelMonAppClient(this);
		this.view = new ViewMonAppClient();
	}
	
	/**
	 * 
	 */
	public void startTEST() {
		String testretour = (String) model.invokeMethodOnControllerAppServer("testAppServer", new Class[] {}, new Object[] {});
		System.out.println(testretour);
	}
	
	/**
	 * @return
	 */
	public String testAppClient() {
		return "retour methode de test sur client";
	}
}
