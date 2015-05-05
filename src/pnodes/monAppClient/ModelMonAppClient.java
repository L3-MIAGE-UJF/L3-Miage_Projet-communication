package pnodes.monAppClient;

import onodes.Model;
import onodes.RMI.Client.ControllerRMIClient;

import java.rmi.RemoteException;
import java.util.Observable;

public class ModelMonAppClient extends Observable implements Model {

	private ControllerRMIClient<ControllerMonAppClient> cRMIc;
	
	public ModelMonAppClient(ControllerMonAppClient controllerAppClient) throws RemoteException {
		cRMIc=new ControllerRMIClient<ControllerMonAppClient>(controllerAppClient, "127.0.0.1");
	}

	public Object invokeMethodOnControllerAppServer(String methodName, Class[] cArgs, Object[] oArgs) {
		return cRMIc.invokeMethodOnControllerAppServer(methodName, cArgs, oArgs);
	}
}
