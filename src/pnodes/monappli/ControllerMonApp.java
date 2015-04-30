package pnodes.monappli;
import onodes.Controller;

public class ControllerMonApp extends Controller<ModelMonApp, ViewMonApp> {

	public ControllerMonApp() {
		this.model = new ModelMonApp();
		this.view = new ViewMonApp(this, this.model);
		this.model.addObserver(view);
	}

	public ControllerMonApp(ModelMonApp model, ViewMonApp view) {
		super(model, view);
	}
	
	public void actionBouton() {
		System.out.println("Recuperation action lancement traitement");
		model.traitementActionBouton();
	}
}
