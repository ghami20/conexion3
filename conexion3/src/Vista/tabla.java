package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controlador.UsuarioControlador;
import Modelo.Usuario;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tabla extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private UsuarioControlador controlador;
    private JLabel elemento;
    private Usuario seleccionado;

    /**
     * Launch the application.
     */
    
    /**
     * Create the frame.
     */
    public tabla() {
    	this.setVisible(true);
    	this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 909, 452);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        // Inicializar controlador y usuario seleccionado
        controlador = new UsuarioControlador();
       Usuario seleccionado = new Usuario();

        // Crear la tabla y el modelo
        String[] columnNames = {"ID", "Nombre", "mail"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizarTabla();
        contentPane.setLayout(null);

        // Crear el JScrollPane y agregar la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 19, 911, 190);
        contentPane.add(scrollPane);

        // Crear el JLabel para mostrar la selección
        elemento = new JLabel("Seleccionado:");
        elemento.setBounds(5, 5, 911, 14);
        contentPane.add(elemento);

        // Crear el botón de eliminar
        JButton Eliminar = new JButton("Eliminar");
        Eliminar.setBounds(574, 295, 250, 54);
        Eliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (seleccionado.getId()!=0) {
            	      controlador.deleteUser(seleccionado.getId());
                      actualizarTabla();
                      seleccionado.setId(0);
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un usuario");
				}
          
            }
        });
        contentPane.add(Eliminar);
        
        JButton Editar = new JButton("Editar");
        Editar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if (seleccionado.getId()!=0) {
          	      	Editar editar = new Editar(seleccionado);
                    dispose();
                    seleccionado.setId(0);
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un usuario");
				}
        		
        		
        	}
        });
        Editar.setBounds(109, 295, 250, 54);
        contentPane.add(Editar);

        // Configurar el modelo de selección
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Agregar un escuchador de selección
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        int id = (int) table.getValueAt(selectedRow, 0);
                        String nombre = (String) table.getValueAt(selectedRow, 1);
                        String mail = (String) table.getValueAt(selectedRow, 2);
                        elemento.setText("Seleccionado: ID=" + id + ", Nombre=" + nombre + ", Mail=" + mail);
                        seleccionado.setEmail(mail);
                        seleccionado.setNombre(nombre);
                        seleccionado.setId(id);
                    }
                }
            }
        });
    }

    private void actualizarTabla() {
        // Limpiar el modelo de la tabla
        model.setRowCount(0);

        // Obtener la lista actualizada de usuarios
        List<Usuario> usuarios = controlador.getAllUsers();

        // Agregar los datos al modelo
        for (Usuario usuario : usuarios) {
            model.addRow(
            		new Object[]
            				{usuario.getId()
            						, usuario.getNombre()
            						, usuario.getEmail()
            						}
            		);
        }
    }
}
