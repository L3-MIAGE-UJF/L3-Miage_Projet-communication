package pnodes.monAppClientGeneric;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import onodes.View;

/**
 * @author groupe1
 *
 */
public class ViewMonApp extends JFrame implements View, Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4595300148105306773L;

	//TODO Ajouter listener
	/**
	 * 
	 */
	private ControllerMonApp controller;
	/**
	 * 
	 */
	private ModelMonApp model;
	
	private javax.swing.JPanel panel;
	private javax.swing.JButton bouton;
	private javax.swing.JButton boutonRemote;
	private javax.swing.JLabel textTitre;

	/**
	 * @param controller
	 * @param model
	 */
	public ViewMonApp(ControllerMonApp controller, ModelMonApp model) {
		this.controller=controller;
		this.model=model;
		initComponents();
	}
	
	/**
	 * 
	 */
	private void initComponents() {
		this.setTitle("Animation");

		this.setSize(300, 150);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLocationRelativeTo(null);

		panel = new JPanel();
		bouton = new JButton("Mon bouton");
		boutonRemote = new JButton("Remote");
		textTitre = new JLabel(model.getTitre());
		
		panel.add(bouton);
		panel.add(boutonRemote);
		panel.add(textTitre);

		this.setContentPane(panel);


		bouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	boutonActionPerformed(evt);
            }
        });
 
		boutonRemote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	boutonRemoteActionPerformed(evt);
            }
        });
		
		this.setVisible(true);
	}
	
	/**
	 * @param evt
	 */
	private void boutonActionPerformed(java.awt.event.ActionEvent evt) {
		this.controller.actionBouton();
	}

	/**
	 * @param evt
	 */
	private void boutonRemoteActionPerformed(java.awt.event.ActionEvent evt) {
		this.controller.actionBoutonRemote();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Update ViewApp");
		
		textTitre.setText(model.getTitre());
	}

}