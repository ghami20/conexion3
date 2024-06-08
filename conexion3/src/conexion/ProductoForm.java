package Vista;

import javax.swing.*;
import Controlador.ProductoControlador;
import Modelo.Producto;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ProductoForm extends JFrame {
    private JTextField nombreField;
    private JTextField precioField;
    private JLabel imagenLabel;
    private byte[] imagenData;
    private JLabel label_3;
    private JTextField inpCantidad;

    public ProductoForm() {
        setTitle("Agregar Producto");
        setSize(486, 337);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        nombreField = new JTextField();
        nombreField.setBounds(237, 6, 176, 40);
        precioField = new JTextField();
        precioField.setBounds(237, 57, 191, 40);
        imagenLabel = new JLabel();
        imagenLabel.setBounds(237, 108, 212, 40);

        JButton seleccionarImagenBtn = new JButton("Seleccionar Imagen");
        seleccionarImagenBtn.setBounds(0, 226, 232, 70);
        seleccionarImagenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarImagen();
            }
        });

        JButton guardarBtn = new JButton("Guardar Producto");
        guardarBtn.setBounds(237, 226, 232, 70);
        guardarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });
        getContentPane().setLayout(null);

        JLabel label = new JLabel("Nombre:");
        label.setBounds(10, 1, 185, 50);
        getContentPane().add(label);
        getContentPane().add(nombreField);
        JLabel label_1 = new JLabel("Precio:");
        label_1.setBounds(10, 50, 185, 40);
        getContentPane().add(label_1);
        getContentPane().add(precioField);
        JLabel label_2 = new JLabel("Imagen:");
        label_2.setBounds(10, 101, 185, 40);
        getContentPane().add(label_2);
        getContentPane().add(imagenLabel);
        getContentPane().add(seleccionarImagenBtn);
        getContentPane().add(guardarBtn);
        
        label_3 = new JLabel("cantidad:");
        label_3.setBounds(10, 163, 185, 40);
        getContentPane().add(label_3);
        
        inpCantidad = new JTextField();
        inpCantidad.setBounds(237, 163, 191, 40);
        getContentPane().add(inpCantidad);
    }

    private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            imagenLabel.setText(file.getName());
            imagenData = leerImagen(file);
        }
    }

    private byte[] leerImagen(File file) {
        byte[] bFile = new byte[(int) file.length()];
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            fileInputStream.read(bFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bFile;
    }

    private void guardarProducto() {
        String nombre = nombreField.getText();
        int precio = Integer.parseInt(precioField.getText());
        int cantidad = Integer.parseInt(inpCantidad.getText());
        Producto producto = new Producto(0, nombre, precio, imagenData, cantidad);
        ProductoControlador controlador = new ProductoControlador();
        controlador.addProduct(producto);
        
        JOptionPane.showMessageDialog(this, "Producto guardado exitosamente");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProductoForm().setVisible(true);
            }
        });
    }
}
