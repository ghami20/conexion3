package Modelo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private int id;
    private Timestamp fecha;
    private List<DetalleVenta> detalles;

    public Venta(int id, Timestamp fecha) {
        this.id = id;
        this.fecha = fecha;
        this.detalles = new ArrayList<>();
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }
}
