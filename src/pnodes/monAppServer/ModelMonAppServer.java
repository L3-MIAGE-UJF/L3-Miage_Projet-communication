package pnodes.monAppServer;

import onodes.Model;
import onodes.RMI.Server.ControllerRMIServer;
import onodes.RMI.Server.ModelRMIServer;

import java.rmi.RemoteException;
import java.util.Observable;

public class ModelMonAppServer extends Observable implements Model {

	private ControllerRMIServer cRMIs;
	
	public ModelMonAppServer(ControllerMonAppServer cmappserv) throws RemoteException {
		cRMIs=new ControllerRMIServer(cmappserv);
	}
	
	public void invokeMethodOnAllControllerAppClient(String methodName, Class[] cArgs, Object[] oArgs) {
		cRMIs.invokeMethodOnAllControllerAppClient(methodName, cArgs, oArgs);
	}
	
	public Object invokeMethodOnControllerAppClient(int idClient, String methodName, Class[] cArgs, Object[] oArgs) {
		return cRMIs.invokeMethodOnControllerAppClient(idClient, methodName, cArgs, oArgs);
	}
}
