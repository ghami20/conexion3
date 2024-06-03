package Modelo;

import javax.swing.JOptionPane;

import Controlador.UsuarioControlador;

public class Usuario {
	private int id;
	private String nombre;
	private String email;

	public Usuario(int id, String nombre, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}

	public Usuario(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
	}

	public Usuario() {
		
	}

	public int getId() {
		return id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}

	public String IniciarSesion(String nombre, String mail) {

		UsuarioControlador controlador = new UsuarioControlador();

		if (controlador.getAllUsers().isEmpty()) {
			return "No hay usuarios";
		} else {
			
			for (Usuario usuario : controlador.getAllUsers()) {
				if (usuario.getNombre().equals(nombre) && usuario.getEmail().equals(mail)) {
					return "Ingresa";
				}
			}
		}
		return "No se encontró";

	}


	public String Registrarse(String nombre, String mail) {

		UsuarioControlador controlador = new UsuarioControlador();

		for (Usuario usuario : controlador.getAllUsers()) {
			if (usuario.getNombre().equals(nombre)) {
				return "Usuario existente";
			}
		}
		
		controlador.addUser(new Usuario(nombre,mail));
		return "Ok";

	}
}
