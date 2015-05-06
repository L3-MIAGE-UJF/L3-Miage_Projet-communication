package pnodes.AppChatServer;

import onodes.Model;
import onodes.RMI.Server.ControllerRMIServer;
import java.rmi.RemoteException;
import java.util.Observable;

/**
 * @author groupe1
 *
 */
public class ModelAppChatServer extends Observable implements Model {

	/**
	 * 
	 */
	private ControllerRMIServer<ControllerAppChatServer> cRMIs;
	
	/** 
	 * @param cmappserv
	 * @throws RemoteException
	 */
	public ModelAppChatServer(ControllerAppChatServer cmappserv) throws RemoteException {
		cRMIs=new ControllerRMIServer<ControllerAppChatServer>(cmappserv);
	}
	
	/** Appelle sur les clients une methode.
	 * @param methodName Le nom de la methode a appelle sur l'application client.
	 * @param cArgs Les classes des parametres de la methode.
	 * @param oArgs Les parametres de la methode.
	 */
	public void invokeMethodOnAllControllerAppClient(String methodName, Class[] cArgs, Object[] oArgs) {
		cRMIs.invokeMethodOnAllControllerAppClient(methodName, cArgs, oArgs);
	}
	
	/** Appelle sur un client une methode
	 * @param idClient Le numero de l'utilisateur qui doit utiliser la methode
	 * @param methodName Le nom de la methode a appelle sur l'application client.
	 * @param cArgs Les classes des parametres de la methode.
	 * @param oArgs Les parametres de la methode.
	 * @return
	 */
	public Object invokeMethodOnControllerAppClient(int idClient, String methodName, Class[] cArgs, Object[] oArgs) {
		return cRMIs.invokeMethodOnControllerAppClient(idClient, methodName, cArgs, oArgs);
	}
}
