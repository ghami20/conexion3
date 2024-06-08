package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.DetalleVenta;
import Modelo.Venta;

public class VentaControlador {
    private final Connection connection;

    public VentaControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public List<Venta> getAllVentas() {
        List<Venta> ventas = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM venta");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Venta venta = new Venta(resultSet.getInt("id"), resultSet.getTimestamp("fecha"));
                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }

    public void addVenta(Venta venta) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO venta (fecha) VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setTimestamp(1, venta.getFecha());
            statement.executeUpdate();
            
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                venta.setId(generatedKeys.getInt(1));
                addDetallesVenta(venta);
                System.out.println("Venta insertada exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addDetallesVenta(Venta venta) {
        for (DetalleVenta detalle : venta.getDetalles()) {
            try {
                PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO venta_detalle (venta_id, producto_id, cantidad) VALUES (?, ?, ?)");
                statement.setInt(1, venta.getId());
                statement.setInt(2, detalle.getProductoId());
                statement.setInt(3, detalle.getCantidad());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean deleteVenta(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM venta WHERE id = ?");
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Venta eliminada exitosamente");
                return true;
            }
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deleteDetalleVenta(int detalleId) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM venta_detalle WHERE id = ?");
            statement.setInt(1, detalleId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
