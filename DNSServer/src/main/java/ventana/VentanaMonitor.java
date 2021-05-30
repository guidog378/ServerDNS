package ventana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;

import comunicacion.ReceptorClientes;
import comunicacion.ReceptorServers;
import controlador.Controlador;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class VentanaMonitor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JComboBox comboBox;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMonitor frame = new VentanaMonitor();
					Controlador c = new Controlador();
					Thread t1 = new Thread(new ReceptorClientes());
					Thread t2 = new Thread(new ReceptorServers());
					t1.start();
					t2.start();
					c.setVentana(frame);
					frame.setControlador(c);
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
	public VentanaMonitor() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Registrar Servidor:");
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("IP Servidor:");
		panel_4.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(22);
		
		JLabel lblNewLabel_2 = new JLabel("Puerto Empleado:");
		panel_4.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		panel_4.add(textField_1);
		textField_1.setColumns(22);
		
		JLabel lblNewLabel_4 = new JLabel("Puerto Monitor:");
		panel_4.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		panel_4.add(textField_2);
		textField_2.setColumns(22);
		
		JLabel lblNewLabel_5 = new JLabel("Puerto Totem:");
		panel_4.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		panel_4.add(textField_3);
		textField_3.setColumns(22);
		
		JLabel lblNewLabel_6 = new JLabel("Puerto DNS:");
		panel_4.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		panel_4.add(textField_4);
		textField_4.setColumns(22);
		
		JLabel lblNewLabel_3 = new JLabel("Prioridad:");
		panel_4.add(lblNewLabel_3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Primario", "Secundario"}));
		panel_4.add(comboBox);
		
		btnNewButton = new JButton("Agregar Servidor");
		btnNewButton.setActionCommand("AgregarServidor");
		panel_4.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
	}

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
	
	public void setControlador(Controlador c) {
		this.btnNewButton.addActionListener(c);
	}
    
}
