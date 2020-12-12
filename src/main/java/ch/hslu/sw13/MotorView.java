package ch.hslu.sw13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class MotorView extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger(MotorView.class);
	private final JLabel labelState = new JLabel("The motor is Off.");
	private final JButton buttonOn = new JButton("Turn On");
	private final JButton buttonOff = new JButton("Turn Off");
	private final JButton buttonIncreaseRPM = new JButton("accelerate");
	private final JButton buttonDecreaseRPM = new JButton("deccelerate");
	private final JTextArea textAreaSwitcher = new JTextArea(" Switches");
	private final JTextArea textAreaDisorder = new JTextArea("A Disorder has occured! Error!!!");
	private final JTextArea textAreaRPM = new JTextArea(" RPM:");
	/**
	 * Konstruktor.
	 */
	public MotorView() {
		super("Motor Dashboard");
		this.labelState.setHorizontalAlignment(JLabel.CENTER);
		this.labelState.setBackground(Color.RED);
		this.labelState.setOpaque(true);
		this.setLayout(new GridLayout(4, 2, 3, 3));
		this.add(buttonOn); // 1.1
		this.add(buttonOff);  // 1.2
		this.add(labelState);  // 2.1
		this.add(textAreaDisorder);   // 3.1
		this.add(textAreaRPM);   // 3.1		
		this.add(textAreaSwitcher);   // 2.1
		this.add(buttonIncreaseRPM); // 4.1
		this.add(buttonDecreaseRPM);  // 4.2
		this.buttonOff.setVisible(false);
		this.buttonOn.setVisible(true);
		this.textAreaDisorder.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		LOG.info("GUI-Frame aktiviert und sichtbar.");
	}
	
	public JButton getActiveJButton() {
		if(this.labelState.getBackground().equals(Color.RED)) {
			return buttonOff;
		}
		else {
			return buttonOn;
		}
	}

	public void setLabelState(String s, Color color) {
		labelState.setText(s);
		labelState.setBackground(color);
		if(color.equals(Color.RED)) {
			this.buttonOff.setVisible(false);
			this.buttonOn.setVisible(true);
		} else if (color.equals(Color.GREEN)){
			this.buttonOn.setVisible(false);
			this.buttonOff.setVisible(true);
		}
	}
	public void setTextAreaSwitcher(int s) {
		textAreaSwitcher.setText("Switches: " + String.valueOf(s));
		/*//------ simulierte Störung ----
		if((s%3 == 1)) {
			this.textAreaDisorder.setVisible(true);
		} else {
			this.textAreaDisorder.setVisible(false);
		}*/
	}
	
	public void setTextAreaRPM(int i) {
		textAreaRPM.setText("RPM: " + String.valueOf(i));
	}

	public JButton getOnButton() {
		return buttonOn;
	}
	public JButton getOffButton() {
		return buttonOff;
	}
	public JButton getButtonIncreaseRPM() {
		return buttonIncreaseRPM;
	}
	public JButton getButtonDecreaseRPM() {
		return buttonDecreaseRPM;
	}
	
	public void displayWarningMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "Warning", 2);
	}
	public void displayWarningError(String message) {
		JOptionPane.showMessageDialog(this, message, "Erros", 0);
	}
	
	/**
	 * main-Methode.
	 * @param args nicht verwendet.
	 */
	@SuppressWarnings("unused")
	public static void main(final String[] args) {
		LOG.info("Applikation startet...");
		new MotorView();
	}


}














