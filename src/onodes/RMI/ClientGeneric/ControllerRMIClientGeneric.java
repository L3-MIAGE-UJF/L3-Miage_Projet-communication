package onodes.RMI.ClientGeneric;

import java.rmi.RemoteException;

import onodes.RMI.ControllerRMI;
import onodes.RMI.ServerGeneric.ModelRMIServerGenericRemote;

/*
 * Besoin de conserver la même architecture de package dans Le serveur comme le client
 * afin que les classes puissent être trouvé lors du Naming.lookup()
 */

/**
 *
 * DO NOT EDIT THIS FILE IT BELONG TO THE FRAMEWORK
 * 
 * Ce module defini les elements de bases indispensable afin de developper un module
 * utilisant RMI en tant que client.
 * 
 * Le fonctionnement est tel que le developpeur doit redefinir un module RMI Client
 * pour son application. Et il y insere les methodes qu'il souhaite voir etre utilisable
 * 
 * Tout element d'un module souhaitant interagir avec du RMI en ecrivant ses 
 * methodes devra donc etendre les elements relatif de ce module.
 * 
 * @author groupe1
 *
 */
public abstract class ControllerRMIClientGeneric<MR extends ModelRMIServerGenericRemote, M extends ModelRMIClientGeneric, V extends ViewRMIClientGeneric>
		extends ControllerRMI<M, V> {

	/**
	 * 
	 */
	private MR mRMIServerRemote;

	/**
	 * @param model
	 * @param view
	 * @throws RemoteException
	 */
	public ControllerRMIClientGeneric(M model, V view) throws RemoteException {
		super(model, view);
		setLocalMRMIServerRemote();
	}
	
	/**
	 * 
	 */
	protected void setLocalMRMIServerRemote() {
		try {
			this.mRMIServerRemote = (MR) model.getMRMIServerRemote();
		} catch (NullPointerException e) {
			e.getMessage();
		}
	}
	
	/**
	 * @return
	 */
	public MR getmRMIServerRemote() {
		return mRMIServerRemote;
	}
}
