package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.UsuarioControlador;
import Modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JComboBox;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Home(String nombre) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hola " + nombre);
		lblNewLabel.setBounds(166, 66, 46, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(78, 102, 322, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario seleccionado");
		lblNewLabel_1.setBounds(63, 171, 348, 14);
		contentPane.add(lblNewLabel_1);
		
		UsuarioControlador usuarios = new UsuarioControlador();
		for (Usuario usuario : usuarios.getAllUsers()) {
			comboBox.addItem(usuario);
		}
		
		comboBox.addActionListener(e->{
			
			String seleccionado = (String)comboBox.getSelectedItem();
			lblNewLabel_1.setText("Usuario seleccionado :" + seleccionado);
			
		
		});
		
		
		
	}
}
