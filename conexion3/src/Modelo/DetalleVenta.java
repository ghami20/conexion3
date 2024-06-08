package Modelo;

public class DetalleVenta {
    private int productoId;
    private int cantidad;

    public DetalleVenta(int productoId, int cantidad) {
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
