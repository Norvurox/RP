package Taxi;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JSeparator;

import java.awt.Font;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;

public class Taxi extends JFrame implements KeyListener {


	private JPanel contentPane;
	private JCheckBox nacht;
	private JCheckBox sitz;
	private JCheckBox bar;
	private JComboBox comboBox;
	private JTextField km;
	private JPanel panel;
	private JButton berechnenButton;
	private JButton druckenButton;
	private JButton neuButton;
	private JButton endeButton;
	private JTextField mehrwertsteuer;
	private JTextField bruttobetrag;
	private JTextField nettobetrag;
	private JPanel panel_1;
	private JSeparator separator;
	private JLabel labelNettobetrag;
	private JLabel labelMehrwertsteuer;
	private JLabel labelBruttobetrag;
	private JLabel labelFahrgste;
	private JLabel labelNewLabel;
	private JLabel labelAuswahlDesFahrzeugtyps;
	private JSpinner spinner;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Taxi frame = new Taxi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Taxi() {
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Eingaben", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(6, 0, 343, 164);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				km = new JFormattedTextField(NumberFormat.getInstance());
				km.setHorizontalAlignment(SwingConstants.RIGHT);
				km.setBounds(247, 57, 86, 20);
				panel.add(km);
				km.setColumns(10);
			}
			{
				String comboBoxListe[] = {"Normales Taxi", "Groﬂraum Taxi", "Strechlimousine"};
				comboBox = new JComboBox(comboBoxListe);
				comboBox.setBounds(182, 27, 151, 20);
				panel.add(comboBox);
			}
			{
				bar = new JCheckBox("Bar (Zuschlag 15 \u20AC)");
				bar.setBounds(6, 134, 192, 23);
				panel.add(bar);
			}
			{
				sitz = new JCheckBox("Kindersitz (Zuschlag 1 \u20AC)");
				sitz.setBounds(6, 110, 192, 23);
				panel.add(sitz);
			}
			{
				nacht = new JCheckBox("Nachtfahrt (Zuschlag 10 %)");
				nacht.setBounds(6, 84, 192, 23);
				panel.add(nacht);
			}
			{
				labelFahrgste = new JLabel("Fahrg\u00E4ste");
				labelFahrgste.setBounds(242, 132, 56, 21);
				panel.add(labelFahrgste);
			}
			{
				labelNewLabel = new JLabel("Entfernung in km");
				labelNewLabel.setBounds(10, 58, 226, 21);
				panel.add(labelNewLabel);
			}
			{
				labelAuswahlDesFahrzeugtyps = new JLabel("Auswahl des Fahrzeugtyps");
				labelAuswahlDesFahrzeugtyps.setBounds(10, 26, 158, 21);
				panel.add(labelAuswahlDesFahrzeugtyps);
			}
			{
				spinner = new JSpinner();
				spinner.setBounds(304, 132, 29, 20);
				panel.add(spinner);
			}
		}
		{
			berechnenButton = new JButton("Berechnen");
			berechnenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonNewButtonActionPerformed(e);
					calc();
				}
			});
			berechnenButton.setBounds(250, 168, 89, 23);
			contentPane.add(berechnenButton);
		}
		{
			druckenButton = new JButton("Drucken");
			druckenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonNewButtonActionPerformed(e);
					drucken();
				}
			});
			druckenButton.setBounds(250, 202, 89, 23);
			contentPane.add(druckenButton);
		}
		{
			neuButton = new JButton("Neu");
			neuButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonNewButtonActionPerformed(e);
					clearcalc();
				}
			});
			neuButton.setBounds(250, 236, 89, 23);
			contentPane.add(neuButton);
			
		}
		{
			endeButton = new JButton("Ende");
			endeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			endeButton.setBounds(250, 274, 89, 23);
			contentPane.add(endeButton);
		}
		{
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rechnungs\u00FCbersicht", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(6, 166, 212, 138);
			contentPane.add(panel_1);
			{
				mehrwertsteuer = new JTextField();
				mehrwertsteuer.setText("0");
				mehrwertsteuer.setHorizontalAlignment(SwingConstants.RIGHT);
				mehrwertsteuer.setEditable(false);
				mehrwertsteuer.setBounds(120, 50, 56, 20);
				panel_1.add(mehrwertsteuer);
				mehrwertsteuer.setColumns(10);
			}
			{
				bruttobetrag = new JTextField();
				bruttobetrag.setText("0");
				bruttobetrag.setHorizontalAlignment(SwingConstants.RIGHT);
				bruttobetrag.setEditable(false);
				bruttobetrag.setBounds(120, 94, 56, 20);
				panel_1.add(bruttobetrag);
				bruttobetrag.setColumns(10);
			}
			{
				nettobetrag = new JTextField();
				nettobetrag.setText("0");
				nettobetrag.setHorizontalAlignment(SwingConstants.RIGHT);
				nettobetrag.setEditable(false);
				nettobetrag.setBounds(120, 24, 56, 20);
				panel_1.add(nettobetrag);
				nettobetrag.setColumns(10);
			}
			{
				separator = new JSeparator();
				separator.setBounds(10, 81, 166, 2);
				panel_1.add(separator);
			}
			{
				labelNettobetrag = new JLabel("Nettobetrag");
				labelNettobetrag.setBounds(10, 24, 100, 17);
				panel_1.add(labelNettobetrag);
			}
			{
				labelMehrwertsteuer = new JLabel("Mehrwertsteuer");
				labelMehrwertsteuer.setBounds(10, 50, 100, 17);
				panel_1.add(labelMehrwertsteuer);
			}
			{
				labelBruttobetrag = new JLabel("Bruttobetrag");
				labelBruttobetrag.setBounds(10, 94, 100, 17);
				panel_1.add(labelBruttobetrag);
			}
			{
				label = new JLabel("\u20AC");
				label.setBounds(183, 27, 19, 14);
				panel_1.add(label);
			}
			{
				label_1 = new JLabel("\u20AC");
				label_1.setBounds(183, 53, 19, 14);
				panel_1.add(label_1);
			}
			{
				label_2 = new JLabel("\u20AC");
				label_2.setBounds(183, 97, 19, 14);
				panel_1.add(label_2);
			}
		}
	}
	
	private void calc() {
		double kmet = 0;
		double barzahl = 0;
		double pricekm = 0;
		double brutto = 3.90;
		double taxipaylo = 0;
		try {
			kmet = Double.parseDouble(km.getText().trim().replace(",","."));
			if (sitz.isSelected()) {
				brutto += 1;
			}
			if (bar.isSelected()) {
				barzahl = (int) spinner.getValue() * 15; 
			}
			if (comboBox.getSelectedIndex() == 0) {
				pricekm = 0.5;
			}
			if (comboBox.getSelectedIndex() == 1) {
				pricekm = 1.0;
			}
			if (comboBox.getSelectedIndex() == 2) {
				pricekm = 2.0;
			}
			if (nacht.isSelected()) {
				pricekm *= 1.1;
			}
			
			taxipaylo = kmet * pricekm;
			
			brutto += taxipaylo + barzahl;
			double tax = (brutto / 100) * 7;
			double netto = brutto - tax;
			
			brutto = Math.round(brutto * 100.0) / 100.0;
			tax = Math.round(tax * 100.0) / 100.0;
			netto = Math.round(netto * 100.0) / 100.0;
			
			nettobetrag.setText(String.valueOf(netto));
			bruttobetrag.setText(String.valueOf(brutto));
			mehrwertsteuer.setText(String.valueOf(tax));
			
			
			
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Bitte geben Sie eine Entfernung an.", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void clearcalc() {
		nettobetrag.setText("0");
		bruttobetrag.setText("0");
		mehrwertsteuer.setText("0");
		comboBox.setSelectedIndex(0);
		nacht.setSelected(false);
		sitz.setSelected(false);
		bar.setSelected(false);
		spinner.setValue(0);
		km.setText("0");
	}
	
	private void drucken() {
		System.out.println("Rechnung Taxi" +
							"\nEntfernung: "+km.getText()+
							"\nBetrag: "+ bruttobetrag.getText());
	}
	
	protected void buttonNewButtonActionPerformed(ActionEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
