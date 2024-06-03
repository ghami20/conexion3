package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registrarse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Registrarse() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 207, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnombre = new JLabel("nombre");
		lblnombre.setBounds(74, 44, 46, 14);
		contentPane.add(lblnombre);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(54, 69, 86, 20);
		contentPane.add(textField);
		
		JLabel lblcontrasena = new JLabel("contraseña");
		lblcontrasena.setBounds(54, 100, 86, 14);
		contentPane.add(lblcontrasena);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(54, 121, 86, 20);
		contentPane.add(passwordField);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 152, 171, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);

		JButton btnEnviar = new JButton("Registrarse");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Usuario nuevo = new Usuario();
				String respuesta = nuevo.Registrarse(textField.getText(),passwordField.getText() );
				if (respuesta.equals("Ok")) {
					Home home = new Home(textField.getText());
					dispose();
				} else {
					lblNewLabel.setText(respuesta);
					lblNewLabel.setVisible(true);
				}
				
			}
		});
		btnEnviar.setBounds(53, 177, 89, 23);
		contentPane.add(btnEnviar);
		
	
	}

}
