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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

@SuppressWarnings("restriction")
public final class SpeedMeasurementsView extends JFrame {

	private static final Logger LOG = LogManager.getLogger(SpeedMeasurementsView.class);
	private static final long serialVersionUID = 1L;
	private final JLabel labelFastes = new JLabel("         Fastes Downloadspeed:        ");
	private final JTextArea textAreaMax = new JTextArea(6, 0);
	private final JLabel labelSlowest = new JLabel("Slowest Downloadspeed:");
	private final JTextArea textAreaMin = new JTextArea(6, 0);
	private final JButton buttonOpenFile = new JButton("Open File");
	private final JButton buttonOK = new JButton("OK");
	private final JTextArea textAreaFile = new JTextArea(" Selected File:");
	private final JLabel labelAverage = new JLabel(" Average Speed:");
	private final JTextArea textAreaAverage = new JTextArea("");

	/**
	 * Konstruktor.
	 */
	public SpeedMeasurementsView() {
		super("Internet speed evaluation");
		this.setLayout(new BorderLayout());

		// SpeedPanel
		JPanel speedPanel = new JPanel();
		speedPanel.setLayout(new GridLayout(3, 2, 7, 12));
		this.add(speedPanel, BorderLayout.NORTH);

		speedPanel.add(labelFastes); // 1.1
		speedPanel.add(textAreaMax); // 1.2
		speedPanel.add(labelSlowest); // 2.1
		speedPanel.add(textAreaMin); // 2.2
		labelSlowest.setHorizontalAlignment(JLabel.CENTER);
		labelFastes.setHorizontalAlignment(JLabel.CENTER);
		speedPanel.add(labelAverage); // 4.2
		speedPanel.add(textAreaAverage); // 4.2
		labelAverage.setHorizontalAlignment(JLabel.CENTER);

		// ControlPanel
		JPanel controlPanel = new JPanel();
		controlPanel.add(buttonOpenFile); // 3.1
		controlPanel.add(buttonOK); // 3.2
		// controlPanel.add(textAreaEmpty); // 4.1

		controlPanel.setLayout(new GridLayout(1, 2, 7, 12));
		this.add(controlPanel, BorderLayout.CENTER);

		// Selected File
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 1, 7, 12));
		bottomPanel.add(textAreaFile);
		textAreaFile.setVisible(true);
		this.add(bottomPanel, BorderLayout.SOUTH);

		this.setSize(500, 500);
		this.setVisible(true);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		LOG.info("GUI-Frame aktiviert und sichtbar.");
	}

	public File selectFile() {
		final JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
		fc.setFileFilter(filter);

		int result = fc.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			// user selects a file
			File selectedFile = fc.getSelectedFile();
			this.textAreaFile.setVisible(true);
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

	public void setTextAreaAverage(float average, int count) {
		textAreaAverage.setText("" + average + " MBit/s\n" + "with " + count + " measurements");
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
	 * 
	 * @param args nicht verwendet.
	 */
	@SuppressWarnings("unused")
	public static void main(final String[] args) {
		LOG.info("Applikation startet...");
		new SpeedMeasurementsView();
	}

}
