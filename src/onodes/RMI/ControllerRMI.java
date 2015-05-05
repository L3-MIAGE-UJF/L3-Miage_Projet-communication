package onodes.RMI;

import onodes.Controller;

/**
 * @author groupe1
 *
 * @param <M>
 * @param <V>
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
