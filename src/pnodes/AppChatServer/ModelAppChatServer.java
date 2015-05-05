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
	
	/**
	 * @param methodName
	 * @param cArgs
	 * @param oArgs
	 */
	public void invokeMethodOnAllControllerAppClient(String methodName, Class[] cArgs, Object[] oArgs) {
		cRMIs.invokeMethodOnAllControllerAppClient(methodName, cArgs, oArgs);
	}
	
	/**
	 * @param idClient
	 * @param methodName
	 * @param cArgs
	 * @param oArgs
	 * @return
	 */
	public Object invokeMethodOnControllerAppClient(int idClient, String methodName, Class[] cArgs, Object[] oArgs) {
		return cRMIs.invokeMethodOnControllerAppClient(idClient, methodName, cArgs, oArgs);
	}
}
