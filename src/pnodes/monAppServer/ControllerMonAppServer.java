package pnodes.monAppServer;

import java.rmi.RemoteException;

import onodes.Controller;

/**
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
