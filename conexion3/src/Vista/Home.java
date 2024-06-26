package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public Home(String nombre) {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido " + nombre);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(28, 11, 398, 48);
		contentPane.add(lblNewLabel);
		
		JButton verusuarios = new JButton("Ver usuarios");
		
		verusuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabla nueva = new tabla();
				dispose();
				
			}
		});
		verusuarios.setBounds(54, 110, 153, 23);
		contentPane.add(verusuarios);
	}

}
