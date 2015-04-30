package pnodes.monappli;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import onodes.View;

public class ViewMonApp extends JFrame implements View, Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4595300148105306773L;

	//TODO Temporaire, ajouter listener
	private ControllerMonApp controller;
	private ModelMonApp model;
	
	private javax.swing.JPanel panel;
	private javax.swing.JButton bouton;
	private javax.swing.JLabel textTitre;

	public ViewMonApp(ControllerMonApp controller, ModelMonApp model) {
		this.controller=controller;
		this.model=model;
		initComponents();
	}
	
	private void initComponents() {
		this.setTitle("Animation");

		this.setSize(300, 150);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLocationRelativeTo(null);

		panel = new JPanel();
		bouton = new JButton("Mon bouton");
		textTitre = new JLabel(model.getTitre());
		
		panel.add(bouton);
		panel.add(textTitre);

		this.setContentPane(panel);


		bouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	boutonActionPerformed(evt);
            }
        });
 
		this.setVisible(true);
	}
	
	private void boutonActionPerformed(java.awt.event.ActionEvent evt) {
		this.controller.actionBouton();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("Update ViewApp");
		
		textTitre.setText(model.getTitre());
	}

}