package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Usuario;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.concurrent.ForkJoinPool;
import java.awt.event.ActionEvent;

public class Registrarse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */

	
	public Registrarse() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(205, 77, 86, 20);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(205, 117, 86, 20);
		contentPane.add(passwordField);
		
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Usuario nuevo = new Usuario();
				
				
				if(nuevo.Registrarse(textField.getText(), passwordField.getText())) {
					Home home = new Home(textField.getText());
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Error");
				}
				
			}
		});
		btnCrearCuenta.setBounds(202, 174, 128, 23);
		contentPane.add(btnCrearCuenta);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(205, 96, 86, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(218, 52, 46, 14);
		contentPane.add(lblNombre);
	}

}
