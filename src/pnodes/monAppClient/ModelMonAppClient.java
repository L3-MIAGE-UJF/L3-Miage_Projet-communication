package pnodes.monAppClient;

import onodes.Model;
import onodes.RMI.Client.ControllerRMIClient;

import java.rmi.RemoteException;
import java.util.Observable;

/**
 * @author groupe1
 *
 */
public class ModelMonAppClient extends Observable implements Model {

	/**
	 * 
	 */
	private ControllerRMIClient<ControllerMonAppClient> cRMIc;
	
	/**
	 * @param controllerAppClient
	 * @throws RemoteException
	 */
	public ModelMonAppClient(ControllerMonAppClient controllerAppClient) throws RemoteException {
		cRMIc=new ControllerRMIClient<ControllerMonAppClient>(controllerAppClient, "152.77.82.80");
	}

	/**
	 * @param methodName
	 * @param cArgs
	 * @param oArgs
	 * @return
	 */
	public Object invokeMethodOnControllerAppServer(String methodName, Class[] cArgs, Object[] oArgs) {
		return cRMIc.invokeMethodOnControllerAppServer(methodName, cArgs, oArgs);
	}
}
