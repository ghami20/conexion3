package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.List;

import Controlador.ProductoControlador;
import Controlador.UsuarioControlador;
import Controlador.VentaControlador;
import Modelo.Producto;
import Modelo.Usuario;
import Modelo.Venta;
import Modelo.DetalleVenta;

public class VentaForm extends JFrame {
    private JComboBox<Producto> productoComboBox;
    private JTextField cantidadField;
    private JButton agregarProductoBtn;
    private JButton guardarVentaBtn;
    private JTextArea ticketArea;
    private Venta ventaActual;
    private VentaControlador ventaControlador;
    private ProductoControlador productoControlador;
    private UsuarioControlador usuarioControlador;
    private Usuario usuarioActual;

    public VentaForm(Usuario usuario) {
        this.usuarioActual = usuario; // Guardar el usuario actual
        setTitle("Gestionar Ventas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Inicializar controladores
        ventaControlador = new VentaControlador();
        productoControlador = new ProductoControlador();

        // Panel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        productoComboBox = new JComboBox<>();
        cantidadField = new JTextField();
        agregarProductoBtn = new JButton("Agregar Producto");
        guardarVentaBtn = new JButton("Guardar Venta");

        inputPanel.add(new JLabel("Producto:"));
        inputPanel.add(productoComboBox);
        inputPanel.add(new JLabel("Cantidad:"));
        inputPanel.add(cantidadField);

        add(inputPanel, BorderLayout.NORTH);

        // Área para mostrar el ticket
        ticketArea = new JTextArea();
        add(new JScrollPane(ticketArea), BorderLayout.CENTER);

        // Acción del botón Agregar Producto
        agregarProductoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        // Acción del botón Guardar Venta
        guardarVentaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarVenta();
            }
        });

        // Panel para botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(agregarProductoBtn);
        buttonPanel.add(guardarVentaBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        // Cargar productos disponibles
        cargarProductos();

        // Inicializar la venta actual
        ventaActual = new Venta(0, new Timestamp(System.currentTimeMillis()));
    }

    private void cargarProductos() {
        List<Producto> productos = productoControlador.getAllProducts();
        for (Producto producto : productos) {
            productoComboBox.addItem(producto);
        }
    }

    private void agregarProducto() {
        Producto producto = (Producto) productoComboBox.getSelectedItem();
        int cantidad = Integer.parseInt(cantidadField.getText());

        // Verificar si el producto ya está en la venta actual
        for (DetalleVenta detalle : ventaActual.getDetalles()) {
            if (detalle.getProductoId() == producto.getId()) {
                // Si el producto ya está en la venta, actualizar la cantidad y salir del método
                detalle.setCantidad(detalle.getCantidad() + cantidad);
                actualizarTicket();
                return;
            }
        }

        // Si el producto no está en la venta, agregarlo como un nuevo detalle
        ventaActual.getDetalles().add(new DetalleVenta(producto.getId(), cantidad));

        actualizarTicket();
    }

    private void actualizarTicket() {
        ticketArea.setText("Ticket de Venta:\n\n");
        double total = 0.0;
        for (DetalleVenta detalle : ventaActual.getDetalles()) {
            Producto producto = productoControlador.getProductById(detalle.getProductoId());
            double subtotal = detalle.getCantidad() * producto.getPrecio();
            total += subtotal;
            ticketArea.append(producto.getNombre() + "\tCantidad: " + detalle.getCantidad() + "\tSubtotal: $" + subtotal + "\n");
        }
        ticketArea.append("\nTotal: $" + total);
    }

    private void guardarVenta() {
        // Verificar la disponibilidad de productos antes de guardar la venta
        if (!verificarDisponibilidadProductos()) {
            JOptionPane.showMessageDialog(this, "No hay suficiente stock disponible para completar la venta.");
            return;
        }

        // Restar la cantidad vendida del stock de productos
        restarCantidadProductos();

        // Guardar la venta en la base de datos
        ventaControlador.addVenta(ventaActual); // Pasar el usuario actual al guardar la venta
        JOptionPane.showMessageDialog(this, "Venta guardada exitosamente");

        // Limpiar venta actual y actualizar ticket
        ventaActual = new Venta(0, new Timestamp(System.currentTimeMillis()));
        actualizarTicket();
    }

    private boolean verificarDisponibilidadProductos() {
        for (DetalleVenta detalle : ventaActual.getDetalles()) {
            Producto producto = productoControlador.getProductById(detalle.getProductoId());
            if (producto.getCantidad() < detalle.getCantidad()) {
                return false;
            }
        }
        return true;
    }

    private void restarCantidadProductos() {
        for (DetalleVenta detalle : ventaActual.getDetalles()) {
            Producto producto = productoControlador.getProductById(detalle.getProductoId());
            int nuevaCantidad = producto.getCantidad() - detalle.getCantidad();
            producto.setCantidad(nuevaCantidad);
            productoControlador.updateProduct(producto);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Aquí deberías obtener el usuario actual de la aplicación
                Usuario usuario = obtenerUsuarioActual();

                new VentaForm(usuario).setVisible(true);
            }
        });
    }

    private static Usuario obtenerUsuarioActual() {
     
        return new Usuario(1, "Gamaliel", "Ghami@gmail.com", 1);
    }
}
