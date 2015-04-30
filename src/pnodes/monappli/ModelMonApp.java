package pnodes.monappli;

import onodes.Model;
import java.util.Observable;

public class ModelMonApp extends Observable implements Model {

	private String titre = "Origin";
	private int compteur = 0;
	
	public ModelMonApp() {
	}
	/*
	public ModelMonApp(ViewMonApp view) {
		this.addObserver(view);
	}
	*/
	
	public void traitementActionBouton() {
		System.out.println("Traitement de l'action du bouton");
		titre="nouveau string";
		setChanged();
		notifyObservers();
	}
	
	public String getTitre() {
		compteur++;
		return titre+" "+compteur;
	}
}
