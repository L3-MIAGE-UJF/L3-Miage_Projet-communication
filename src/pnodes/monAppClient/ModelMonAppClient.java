package pnodes.monAppClient;

import onodes.Model;
import onodes.RMI.Client.ControllerRMIClient;
import onodes.RMI.Server.ModelRMIServer;
import onodes.RMI.Server.ModelRMIServerRemote;

import java.rmi.RemoteException;
import java.util.Observable;

public class ModelMonAppClient extends Observable implements Model {

	private ControllerRMIClient cRMIc;
	
	public ModelMonAppClient() throws RemoteException {
		cRMIc=new ControllerRMIClient();
	}

	public Object invokeMethodOnControllerAppServer(String methodName, Class[] args) {
		return cRMIc.invokeMethodOnControllerAppServer(methodName, args);
	}
}
