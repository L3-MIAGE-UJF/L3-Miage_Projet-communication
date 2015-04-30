package onodes.RMI;

import onodes.Controller;

public abstract class ControllerRMI<M extends ModelRMI, V extends ViewRMI> extends Controller<M, V> {
	public ControllerRMI() {
		super();
	}
	
	public ControllerRMI(M model, V view) {
		super(model, view);
	}
}
