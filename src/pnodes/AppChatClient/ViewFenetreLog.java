package pnodes.AppChatClient;

import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;


import javax.swing.JFrame;


import onodes.View;

/**
 *
 * @author groupe1
 */
public class ViewFenetreLog extends JFrame implements Observer,View {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7073117859384428054L;
	private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    private ViewAppChatClient view;

	/**
	 * @param controller
	 * @param view
	 */
	public ViewFenetreLog(ControllerAppChatClient controller, ViewAppChatClient view) {
    	this.view = view;
        initComponents();
        this.setVisible(true);
    }

    /**
     * Initialise la fenetre graphique
     */
    private void initComponents() {
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setText("");

        jButton1.setText("Login");
        jButton1.addActionListener(new PressLog(this.view));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        

        this.pack();
    }


    
    class PressLog implements ActionListener{
    	private ViewAppChatClient view;
    	public PressLog(ViewAppChatClient view){
    		this.view = view;
    		
    	}
		/**
		 * Signale a la vue qu'il y a eu une action de connexion en tant qu'utilisateur.
		 *
		 */
    	public void actionPerformed(java.awt.event.ActionEvent evt) {
    			this.view.buttonActionLogin(evt,jTextField1.getText());
        }
    }

	@Override
	public void update(Observable arg0, Object arg1) {
	}
}
