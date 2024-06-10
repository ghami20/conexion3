package Vista;
import javax.swing.*;
import java.awt.event.*;

public class LinkExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Link Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear un JLabel con el texto del enlace
        JLabel linkLabel = new JLabel("Visita mi sitio web");
        // Cambiar el color y el subrayado para que parezca un enlace
        linkLabel.setForeground(java.awt.Color.BLUE);
        linkLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        // Agregar un listener de clic al JLabel
        linkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Abrir el enlace en el navegador predeterminado
                try {
                    java.awt.Desktop.getDesktop().browse(new java.net.URI("http://www.ejemplo.com"));
                } catch (java.io.IOException | java.net.URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Agregar el JLabel al JFrame
        frame.getContentPane().add(linkLabel);

        frame.pack();
        frame.setVisible(true);
    }
}
