package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class PantallaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField InpNombre;
	private JPasswordField inpContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicio frame = new PantallaInicio();
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
	public PantallaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(112, 53, 46, 14);
		contentPane.add(lblNombre);
		
		InpNombre = new JTextField();
		InpNombre.setBounds(99, 78, 86, 20);
		contentPane.add(InpNombre);
		InpNombre.setColumns(10);

		inpContrasena = new JPasswordField();
		inpContrasena.setBounds(99, 118, 86, 20);
		contentPane.add(inpContrasena);
		JLabel lblError = new JLabel("Error al iniciar sesión");
		lblError.setForeground(Color.RED);
		lblError.setBounds(81, 153, 104, 14);
		contentPane.add(lblError);
		lblError.setVisible(false);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Usuario nuevo = new Usuario();
				
				if (nuevo.IniciarSesion(InpNombre.getText(), inpContrasena.getText())) {
					lblError.setVisible(false);
					Home home = new Home(InpNombre.getText());
					dispose();
				} else {
					lblError.setVisible(true);

				}
				
				
				
			}
		});
		btnNewButton.setBounds(20, 178, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registrarse registrarse = new Registrarse();
				dispose();
				
			}
		});
		btnRegistrarse.setBounds(170, 178, 89, 23);
		contentPane.add(btnRegistrarse);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(99, 97, 86, 14);
		contentPane.add(lblContrasea);
		
		
	}
}
