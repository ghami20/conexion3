package Vista;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    public static void main(String[] args) {
        // Crear una nueva instancia de JFrame
        JFrame ventana = new JFrame("Ventana con Menú");

        // Configurar el tamaño de la ventana
        ventana.setSize(400, 300);

        // Hacer que la ventana se cierre correctamente al presionar el botón de cerrar
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un menú
        JMenu menu = new JMenu("Archivo");

        // Crear elementos del menú
        JMenuItem itemNuevo = new JMenuItem("Nuevo");
        JMenuItem itemAbrir = new JMenuItem("Abrir");
        JMenuItem itemGuardar = new JMenuItem("Guardar");
        JMenuItem itemSalir = new JMenuItem("Salir");

        // Agregar elementos al menú
        menu.add(itemNuevo);
        menu.add(itemAbrir);
        menu.add(itemGuardar);
        menu.addSeparator(); // Separador entre elementos
        menu.add(itemSalir);

        // Agregar ActionListener a cada elemento del menú
        itemNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica cuando se selecciona "Nuevo"
                JOptionPane.showMessageDialog(null, "Se seleccionó Nuevo");
            }
        });

        itemAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica cuando se selecciona "Abrir"
            	JOptionPane.showMessageDialog(null,"Se seleccionó Abrir");
            }
        });

        itemGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica cuando se selecciona "Guardar"
            	JOptionPane.showMessageDialog(null,"Se seleccionó Guardar");
            }
        });

        itemSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica cuando se selecciona "Salir"
            	JOptionPane.showMessageDialog(null,"Se seleccionó Salir");
                System.exit(0); // Salir de la aplicación
            }
        });

        // Crear una barra de menú y agregar el menú a la barra
        JMenuBar barraMenu = new JMenuBar();
        barraMenu.add(menu);

        // Establecer la barra de menú en la ventana
        ventana.setJMenuBar(barraMenu);

        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}