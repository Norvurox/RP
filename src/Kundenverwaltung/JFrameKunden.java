package Kundenverwaltung;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.ButtonGroup;

public class JFrameKunden extends JFrame {

	private JPanel contentPane;
	private JLabel lblName;
	private JLabel lblVorname;
	private JTextField txtfieldName;
	private JTextField txtfieldVorname;
	private JRadioButton bronze;
	private JPanel panel;
	private JRadioButton silber;
	private JRadioButton gold;
	private JSlider slider;
	private JButton buttonDatendrucken;
	private JButton buttonEnde;
	private JCheckBox checkBoxKatalogSchicken;
	private JLabel lblRabatt;
	private JLabel labelHuso;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameKunden frame = new JFrameKunden();
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
	public JFrameKunden() {
		initGUI();
	}
	private void drucken() {
		System.out.println("Name: "+ txtfieldName.getText() + "\nVorname: "+ txtfieldVorname.getText());
		if (bronze.isSelected()) {
			System.out.println("Kundenstatus: Bronze"); 
		}
		else if (silber.isSelected()) {
			System.out.println("Kundenstatus: Silber"); 
		}
		else if (gold.isSelected()) {
			System.out.println("Kundenstatus: Gold"); 
		}
		
		System.out.println("Rabatt: " + slider.getValue() + "%");
		
		if (checkBoxKatalogSchicken.isSelected()) {
			System.out.println("Katalog Schicken?: Ja"); 
		}
		else {
			System.out.println("Katalog Schicken?: Nein"); 
		}
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblName = new JLabel("Name:");
			lblName.setBounds(10, 84, 53, 14);
			contentPane.add(lblName);
		}
		{
			lblVorname = new JLabel("Vorname:");
			lblVorname.setBounds(10, 115, 81, 14);
			contentPane.add(lblVorname);
		}
		{
			txtfieldName = new JTextField();
			txtfieldName.setBounds(101, 81, 86, 20);
			contentPane.add(txtfieldName);
			txtfieldName.setColumns(10);
		}
		{
			txtfieldVorname = new JTextField();
			txtfieldVorname.setBounds(101, 112, 86, 20);
			contentPane.add(txtfieldVorname);
			txtfieldVorname.setColumns(10);
		}
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kundenstatus", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(197, 70, 122, 108);
			contentPane.add(panel);
			panel.setLayout(null);

			{
				bronze = new JRadioButton("Bronzekunde");
				buttonGroup.add(bronze);
				bronze.setSelected(true);
				bronze.setBounds(6, 26, 102, 14);
				panel.add(bronze);
			}
			{
				silber = new JRadioButton("Silberkunde");
				buttonGroup.add(silber);
				silber.setBounds(6, 54, 96, 14);
				panel.add(silber);
			}
			{
				gold = new JRadioButton("Goldkunde");
				buttonGroup.add(gold);
				gold.setBounds(6, 81, 96, 14);
				panel.add(gold);
			}
		}
		{
			lblRabatt = new JLabel("0% Rabatt");
			lblRabatt.setBounds(72, 153, 78, 14);
			contentPane.add(lblRabatt);
		}
		{
			slider = new JSlider();
		    slider.addChangeListener(new ChangeListener() {
		    	public void stateChanged(ChangeEvent e) {
		    		sliderStateChanged(e);
		    	}
			});
			slider.setPaintLabels(true);
			slider.setMaximum(20);
			slider.setBounds(10, 165, 187, 48);
			contentPane.add(slider);
			slider.setMinorTickSpacing(1);
			slider.setMajorTickSpacing(2);
		}
		{
			buttonDatendrucken = new JButton("Daten drucken");
			buttonDatendrucken.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					drucken();
				}
			});
			buttonDatendrucken.setBounds(211, 195, 108, 23);
			contentPane.add(buttonDatendrucken);
		}
		{
			buttonEnde = new JButton("Tsch\u00FCss");
			buttonEnde.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tschüss();
				}
			});
			buttonEnde.setBounds(211, 217, 108, 23);
			contentPane.add(buttonEnde);
		}
		{
			checkBoxKatalogSchicken = new JCheckBox("Katalog schicken?");
			checkBoxKatalogSchicken.setBounds(10, 213, 164, 23);
			contentPane.add(checkBoxKatalogSchicken);
		}
		{
			labelHuso = new JLabel("");
			labelHuso.setBounds(10, 9, 309, 48);
			contentPane.add(labelHuso);
			ImageIcon szut = new ImageIcon("ressources/internetcafe.jpg"); 
			szut.setImage(szut.getImage().getScaledInstance(labelHuso.getWidth(), labelHuso.getHeight(), Image.SCALE_SMOOTH)); 
			labelHuso.setIcon(szut);
		}
	}
	protected void sliderStateChanged(ChangeEvent e) {
		int wert = slider.getValue();
		lblRabatt.setText(Integer.toString(wert) + "% Rabatt");
	}
	private void tschüss() {
		System.exit(0);
	}
	
	private void KeinNameException(NullPointerException e) {
		JOptionPane.showMessageDialog(this, "Bitte geben sie die Anzahl der Kugeln an.", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
	}
}
