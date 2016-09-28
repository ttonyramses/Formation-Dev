package gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MontreFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private MontrePanel montrePanel = null;

	/**
	 * This is the default constructor
	 */
	public MontreFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 249);
		this.setContentPane(getJContentPane());
		this.setTitle("Montre digitale");
		
		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getMontrePanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes montrePanel	
	 * 	
	 * @return gui.MontrePanel	
	 */
	private MontrePanel getMontrePanel() {
		if (montrePanel == null) {
			montrePanel = new MontrePanel();
		}
		return montrePanel;
	}
	
	public static void main(String[] args) {
		MontreFrame montre = new MontreFrame();
		montre.setVisible(true);
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
