package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Producto;

public class ProductoControlador {
    private final Connection connection;

    public ProductoControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public List<Producto> getAllProducts() {
        List<Producto> productos = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM producto");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Producto producto = new Producto(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getInt("precio"),
                    resultSet.getBytes("imagen"), // Ahora también recuperamos la cantidad
                    resultSet.getInt("cantidad")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public Producto getProductById(int id) {
        Producto producto = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM producto WHERE id = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                producto = new Producto(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getInt("precio"),
                    resultSet.getBytes("imagen"), // También recuperamos la cantidad
                    resultSet.getInt("cantidad")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    public void addProduct(Producto producto) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO producto (nombre, precio, cantidad, imagen) VALUES (?, ?, ?, ?)");
            statement.setString(1, producto.getNombre());
            statement.setInt(2, producto.getPrecio());
            statement.setInt(3, producto.getCantidad()); // Añadimos la cantidad
            statement.setBytes(4, producto.getImagen());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Producto insertado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateProduct(Producto producto) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                "UPDATE producto SET nombre=?, precio=?, cantidad=?, imagen=? WHERE id=?");
            statement.setString(1, producto.getNombre());
            statement.setInt(2, producto.getPrecio());
            statement.setInt(3, producto.getCantidad()); // Actualizamos la cantidad
            statement.setBytes(4, producto.getImagen());
            statement.setInt(5, producto.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Producto actualizado exitosamente");
                return true;
            }
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteProduct(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM producto WHERE id = ?");
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Producto eliminado exitosamente");
                return true;
            }
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateProductQuantity(int id, int newQuantity) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                "UPDATE producto SET cantidad=? WHERE id=?");
            statement.setInt(1, newQuantity);
            statement.setInt(2, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cantidad de producto actualizada exitosamente");
                return true;
            }
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
