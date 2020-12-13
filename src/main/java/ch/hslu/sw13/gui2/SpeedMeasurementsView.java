package ch.hslu.sw13.gui2;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

@SuppressWarnings("restriction")
public final class SpeedMeasurementsView extends JFrame {

	private static final Logger LOG = LogManager.getLogger(SpeedMeasurementsView.class);
	private static final long serialVersionUID = 1L;
	private final JLabel labelFastes = new JLabel("        Fastes Downloadspeed:        ");
	private final JTextArea textAreaMax = new JTextArea(6,0);
	private final JLabel labelSlowest = new JLabel("Slowest Downloadspeed:");
	private final JTextArea textAreaMin = new JTextArea(6,0);
	private final JButton buttonOpenFile = new JButton("Open File");
	private final JButton buttonOK = new JButton("OK");
	private final JTextArea textAreaFile = new JTextArea(" Selected File:");
	private final JTextArea textAreaAverage = new JTextArea(" Average Speed:");

	/**
	 * Konstruktor.
	 */
	public SpeedMeasurementsView() {
		super("Internet speed evaluation");
		this.setLayout(new GridLayout(4, 2, 7, 12));
		this.labelSlowest.setHorizontalAlignment(JLabel.CENTER);		
		this.labelFastes.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(labelFastes); // 1.1
		this.add(textAreaMax);  // 1.2
		this.add(labelSlowest);   // 2.1
		this.add(textAreaMin);   // 2.2
		this.add(buttonOpenFile); // 3.1
		this.add(buttonOK);  // 3.2
		this.add(textAreaFile);  // 4.1
		this.add(textAreaAverage);  // 4.2
        this.setSize(500, 500); 
        this.setVisible(true); 
  
     
        
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		LOG.info("GUI-Frame aktiviert und sichtbar.");
	}
        
        
  
	
	
  
    // function to increase progress 
    public void fill() 
    { 
        int i = 0; 
        try { 
            while (i <= 100) { 
                // fill the menu bar 
                b.setValue(i + 10); 
  
                // delay the thread 
                Thread.sleep(1000); 
                i += 20; 
            } 
        } 
        catch (Exception e) { 
        } 
    } 
		
		
		
		
		
		





	
	public File selectFile() {
	final JFileChooser fc = new JFileChooser();	
	int result = fc.showOpenDialog(null);
	if (result == JFileChooser.APPROVE_OPTION) {
	    // user selects a file
		File selectedFile = fc.getSelectedFile();
		return selectedFile;
	}
	return null;
	
	}

	public void setTextAreaMax(SpeedMeasurement speedMeasurement) {
		textAreaMax.setText(speedMeasurement.toString());
	}
	public void setTextAreaMin(SpeedMeasurement speedMeasurement) {
		textAreaMin.setText(speedMeasurement.toString());
	}
	public void setTextAreaFile(String filename) {
		textAreaFile.setText(" Selected File: " + filename);
	}
	public void setTextAreaAverage(float average) {
		textAreaAverage.setText(" Average Speed: " + average);
	}
	
	
	
	public JButton getButtonOK() {
		return buttonOK;
	}
	public JButton getButtonOpenFile() {
		return buttonOpenFile;
	}
	
	
	public void displayInfoMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "Info", 1);
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
		new SpeedMeasurementsView();
	}


}



