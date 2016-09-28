package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import montre.Montre;

public class MontrePanel extends JPanel implements ActionListener, MouseListener {
	
	private static class AutoRefresh extends Thread {
		
		private MontrePanel mgui;
		
		public AutoRefresh(MontrePanel mgui) {
			this.mgui = mgui;
		}
		
		public void run() {
			while (true) {
				try {
					sleep(100);
					mgui.rafraichir();
					yield();
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		}
	}

	private static final long serialVersionUID = 1L;
	private LabelClignotant labelHeure = null;
	private JButton bouttonMode = null;
	private JButton bouttonAvance = null;
	
	private Montre montre = new Montre();
	private LabelClignotant labelMinute = null;
	private JLabel labelSecondes = null;
	
	//  @jve:decl-index=0:

	/**
	 * This is the default constructor
	 */
	public MontrePanel() {
		super();
		initialize();
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		labelSecondes = new JLabel();
		labelSecondes.setBounds(new Rectangle(226, 92, 47, 38));
		labelSecondes.setText(montre.getSecondesAsString());
		labelMinute = new LabelClignotant();
		labelMinute.setBounds(new Rectangle(152, 31, 64, 58));
		labelMinute.setText(montre.getMinuteAsString());
		labelMinute.setFont(new Font("Arial",Font.BOLD,40));
		labelHeure = new LabelClignotant();
		labelHeure.setText(montre.getHeureAsString());
		labelHeure.setLocation(new Point(81, 31));
		labelHeure.setSize(new Dimension(60, 57));
		labelHeure.setFont(new Font("Arial",Font.BOLD,40));
		this.setSize(300, 200);
		this.setLayout(null);
		this.add(labelHeure);
		this.add(getBouttonMode(), null);
		this.add(getBouttonAvance(), null);
		this.add(labelMinute, null);
		this.add(labelSecondes, null);
		
		new AutoRefresh(this).start();
	}
	


	/**
	 * This method initializes bouttonMode	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBouttonMode() {
		if (bouttonMode == null) {
			bouttonMode = new JButton("Mode");
			bouttonMode.setBounds(new Rectangle(20, 149, 114, 40));
			bouttonMode.addActionListener(this);
		}
		return bouttonMode;
	}

	/**
	 * This method initializes bouttonAvance	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBouttonAvance() {
		if (bouttonAvance == null) {
			bouttonAvance = new JButton("Avance");
			bouttonAvance.setBounds(new Rectangle(162, 151, 115, 40));
			bouttonAvance.addMouseListener(this);
		}
		return bouttonAvance;
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == bouttonMode) {
			montre.mode();
			rafraichir();
		}
		
	}
	
	public void rafraichir() {
		labelMinute.setText(montre.getMinuteAsString());
		labelHeure.setText(montre.getHeureAsString());
		labelSecondes.setText(montre.getSecondesAsString());
		
		labelHeure.setClignotant(montre.isHeureClignotante());
		labelMinute.setClignotant(montre.isMinuteClignotante());
		
		repaint();
		
	}

	public void mouseClicked(MouseEvent event) {}
	public void mouseEntered(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}

	public void mousePressed(MouseEvent event) {
		if (event.getSource() == bouttonAvance) {
			montre.avanceAppuye();
			rafraichir();
		}
		
	}

	public void mouseReleased(MouseEvent event) {
		if (event.getSource() == bouttonAvance) {
			montre.avanceRelache();
			rafraichir();
		}
		
	}

	

}
