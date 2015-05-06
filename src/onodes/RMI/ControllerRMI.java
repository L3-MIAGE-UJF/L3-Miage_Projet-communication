package onodes.RMI;

import onodes.Controller;

/**
 * @author groupe1
 *
 * Ce module defini les elements de bases indispensable afin de developper un module
 * utilisant RMI que ce soit en tant que client ou serveur.
 * Tout element d'un module souhaitant interagir directement avec RMI devra donc
 * etendre les elements relatif de ce module.
 *
 * @param <M> Type du modele instancie par le controlleur doit etendre ModelRMI
 * @param <V> Type de la vue instancie par le controlleur doit etendre ViewRMI
 */
public abstract class ControllerRMI<M extends ModelRMI, V extends ViewRMI> extends Controller<M, V> {
	/**
	 * 
	 */
	public ControllerRMI() {
		super();
	}
	
	/**
	 * @param model
	 * @param view
	 */
	public ControllerRMI(M model, V view) {
		super(model, view);
	}
}
