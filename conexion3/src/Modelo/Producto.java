package Modelo;

import java.util.Arrays;

public class Producto {
    private int id;
    private String nombre;
    private int precio;
    private byte[] imagen;
    private int cantidad;

    public Producto(int id, String nombre, int precio, byte[] imagen ,  int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.cantidad =  cantidad;
    }

    
    
    // Getters y Setters
    
    
    
    public int getId() {
        return id;
    }

    public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", imagen="
				+ Arrays.toString(imagen) + "]";
	}
    
    
}
