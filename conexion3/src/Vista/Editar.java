package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.UsuarioControlador;
import Modelo.Usuario;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpnombre;
	private JTextField inpMail;

	/**
	 * Launch the application.
	 */
	
	
	public Editar(Usuario usuario) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inpnombre = new JTextField();
		inpnombre.setBounds(20, 40, 86, 20);
		contentPane.add(inpnombre);
		inpnombre.setText(usuario.getNombre());
		inpnombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre anterior");
		lblNombre.setBounds(20, 15, 348, 14);
		contentPane.add(lblNombre);
		lblNombre.setText("Nombre anterior " + usuario.getNombre());
		JLabel lblpMail = new JLabel("Mail anterior");
		lblpMail.setBounds(20, 71, 348, 14);
		contentPane.add(lblpMail);
		lblpMail.setText("Mail anterior " +usuario.getEmail());
		inpMail = new JTextField();
		inpMail.setColumns(10);
		inpMail.setText(usuario.getEmail());

		inpMail.setBounds(20, 96, 86, 20);
		contentPane.add(inpMail);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(185, 43, 228, 46);
		contentPane.add(lblError);
		JLabel lblE = new JLabel("");
		lblE.setBounds(250, 71, 46, 14);
		contentPane.add(lblE);
		
		JLabel Id = new JLabel("ID:" + usuario.getId());
		Id.setBounds(266, 43, 46, 14);
		contentPane.add(Id);
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (inpMail.getText().equals(usuario.getEmail())) {
					lblError.setText("No puede repetir mail");
				} else {
					usuario.setEmail(inpMail.getText());
					usuario.setNombre(inpnombre.getText());
					UsuarioControlador  controlador = new UsuarioControlador();
					if (controlador.updateUser(usuario)) {
						tabla nueva = new tabla();
						dispose();
					} else {
						lblE.setText("No se pudo agregar");
					}
					
				
					
				}
				
			}
		});
		btnNewButton.setBounds(20, 167, 89, 23);
		contentPane.add(btnNewButton);
;
		
		
		
		
	}
}
