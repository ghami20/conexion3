package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CheckBox con opciones desplegables");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // Crear un CheckBox
        JCheckBox checkBox = new JCheckBox("Terminos y condiciones");
        panel.add(checkBox);

        // Crear un JComboBox con opciones
        String[] opciones = {"Analista de sistema", "Diseño grafico", "Videojuegos"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setVisible(true); // Ocultar el JComboBox inicialmente
        panel.add(comboBox);

        // Botón para obtener la opción seleccionada del JComboBox
        JButton obtenerSeleccion = new JButton("Obtener Selección");
        obtenerSeleccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    String seleccion = (String) comboBox.getSelectedItem();
                    JOptionPane.showMessageDialog(frame, "Opción seleccionada: " + seleccion);
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, seleccione la casilla de verificación primero.");
                }
            }
        });
        panel.add(obtenerSeleccion);

        // Agregar un ActionListener al CheckBox para mostrar u ocultar el JComboBox
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox.setVisible(checkBox.isSelected());
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
