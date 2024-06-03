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
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PantallaIniciarSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpNombre;
	private JPasswordField inpContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaIniciarSesion frame = new PantallaIniciarSesion();
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
	public PantallaIniciarSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnombre = new JLabel("nombre");
		lblnombre.setBounds(71, 32, 46, 14);
		contentPane.add(lblnombre);
		
		inpNombre = new JTextField();
		inpNombre.setBounds(71, 57, 86, 20);
		contentPane.add(inpNombre);
		inpNombre.setColumns(10);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(26, 140, 229, 14);
		contentPane.add(lblError);
		
		lblError.setVisible(false);
		JButton btnEnviar = new JButton("Ingresar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Usuario nuevo = new Usuario();
				String respuesta = nuevo.IniciarSesion(inpNombre.getText(),inpContrasena.getText());
				if (respuesta.equals("Ingresa")) {
					Home home = new Home(inpNombre.getText());
					lblError.setVisible(false);

					dispose();
				} else {
					lblError.setText(respuesta);
					lblError.setVisible(true);
				}
				
				
				
			}
		});
		btnEnviar.setBounds(26, 165, 89, 23);
		contentPane.add(btnEnviar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				Registrarse registrarse = new Registrarse();
				dispose();
				
			}
		});
		btnRegistrarse.setBounds(144, 165, 89, 23);
		contentPane.add(btnRegistrarse);
		
		inpContrasena = new JPasswordField();
		inpContrasena.setBounds(71, 109, 86, 20);
		contentPane.add(inpContrasena);
		
		JLabel lblcontrasena = new JLabel("contraseña");
		lblcontrasena.setBounds(71, 88, 86, 14);
		contentPane.add(lblcontrasena);
	
	}
}
