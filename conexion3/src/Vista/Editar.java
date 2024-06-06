package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.UsuarioControlador;
import Modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpNombre;
	private JTextField inpMail;
	private UsuarioControlador controlador = new UsuarioControlador();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Editar(Usuario usuario) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(148, 49, 46, 14);
		contentPane.add(lblNewLabel);
		
		inpNombre = new JTextField();
		inpNombre.setBounds(37, 74, 268, 20);
		contentPane.add(inpNombre);
		inpNombre.setColumns(10);
		inpNombre.setText(usuario.getNombre());
		JLabel lblNewLabel_1 = new JLabel("Mail");
		lblNewLabel_1.setBounds(148, 106, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		inpMail = new JTextField();
		inpMail.setBounds(37, 131, 268, 20);
		contentPane.add(inpMail);
		inpMail.setColumns(10);
		inpMail.setText(usuario.getEmail());
		JLabel lblid = new JLabel("Id usuario :" + usuario.getId());
		lblid.setBounds(278, 49, 135, 14);
		contentPane.add(lblid);
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (usuario.getEmail().equals(inpMail.getText())) {
					JOptionPane.showMessageDialog(null, "Debe poner un mail distinto");
				} else {
					usuario.setEmail(inpMail.getText());
					usuario.setNombre(inpNombre.getText());;
					if (controlador.updateUser(usuario)) {
						JOptionPane.showMessageDialog(null, "Pudo editar");
						Home home = new Home(usuario.getNombre());
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No poudo editar");

					}
					
				}
				
			}
		});
		btnNewButton.setBounds(123, 184, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(232, 105, 46, 14);
		contentPane.add(lblError);
		
	
	}
}
