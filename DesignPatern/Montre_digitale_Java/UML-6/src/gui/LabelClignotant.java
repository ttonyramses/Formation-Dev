package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JLabel;

public class LabelClignotant extends JLabel {

	private boolean isClignotant;
	
	public LabelClignotant() {
		
	}

	public LabelClignotant(String arg0) {
		super(arg0);
	}

	public LabelClignotant(Icon arg0) {
		super(arg0);
	}

	public LabelClignotant(String arg0, int arg1) {
		super(arg0, arg1);
	}

	public LabelClignotant(Icon arg0, int arg1) {
		super(arg0, arg1);
	}

	public LabelClignotant(String arg0, Icon arg1, int arg2) {
		super(arg0, arg1, arg2);
	}

	public boolean isClignotant() {
		return isClignotant;
	}

	public void setClignotant(boolean isClignotant) {
		this.isClignotant = isClignotant;
	}

	@Override
	public void paint(Graphics g) {
		
		if (isClignotant) {
			int etape = (int) ((System.currentTimeMillis() / 500) % 2);
			setForeground(etape == 0 ? Color.BLACK : Color.GRAY);
		} else {
			setForeground(Color.BLACK);
		}
		
		super.paint(g);
	}

}
