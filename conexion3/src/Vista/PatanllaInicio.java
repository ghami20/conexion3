package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatanllaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpNombre;
	private JPasswordField inpContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatanllaInicio frame = new PatanllaInicio();
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
	public PatanllaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNombre.setBounds(50, 58, 215, 28);
		contentPane.add(lblNombre);
		
		inpNombre = new JTextField();
		inpNombre.setBounds(46, 101, 215, 38);
		contentPane.add(inpNombre);
		inpNombre.setColumns(10);
		
		inpContraseña = new JPasswordField();
		inpContraseña.setBounds(50, 188, 208, 38);
		contentPane.add(inpContraseña);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblContrasea.setBounds(50, 150, 215, 28);
		contentPane.add(lblContrasea);
		

		JLabel lblError = new JLabel("");
		lblError.setBounds(50, 236, 208, 28);
		contentPane.add(lblError);
		lblError.setVisible(false);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String respuesta = Usuario.IniciarSesion(inpNombre.getText(),inpContraseña.getText());
			 if(respuesta.equals("rol:1")) {
				 //Cliente
				 Home home = new Home(inpNombre.getText());
				 dispose();
			 }else if(respuesta.equals("rol:2")) {
				 //Vendedor
				 Admin admin = new Admin();
				 dispose();
			 }{
				 lblError.setText(respuesta);
				lblError.setVisible(true);

			 }
			}
		});
		btnIngresar.setBounds(50, 275, 193, 50);
		contentPane.add(btnIngresar);
		
		JButton btnRegistrase = new JButton("Registrase");
		btnRegistrase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registro registro = new Registro();
				dispose();
			}
		});
		btnRegistrase.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnRegistrase.setBounds(50, 357, 193, 50);
		contentPane.add(btnRegistrase);
		
	}
}
