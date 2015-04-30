package onodes.RMI.Server;

import java.rmi.RemoteException;

import onodes.RMI.ControllerRMI;

/**
 *
 * DO NOT EDIT THIS FILE IT BELONG TO THE FRAMEWORK
 * 
 * @author groupe1
 *
 */

public abstract class ControllerRMIServer<M extends ModelRMIServer, V extends ViewRMIServer>
		extends ControllerRMI<ModelRMIServer, ViewRMIServer> {

	public ControllerRMIServer() throws RemoteException {
		super();
	}
	
	public ControllerRMIServer(M model, V view) throws RemoteException {
		super(model, view);
	}
}
