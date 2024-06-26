package Modelo;

import javax.swing.JOptionPane;

import Controlador.UsuarioControlador;

public class Usuario {
	private int id;
	private String nombre;
	private String email;
	private int rol;

	public Usuario(int id, String nombre, String email,int rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.rol=rol;
	}

	public Usuario(String nombre, String email,int rol) {
		this.nombre = nombre;
		this.email = email;
		this.rol=rol;
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

	
	
	
	
	
	
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", rol=" + rol + "]";
	}

	public static String IniciarSesion(String nombre, String mail) {

		UsuarioControlador controlador = new UsuarioControlador();

		if (controlador.getAllUsers().isEmpty()) {
			return "No hay usuarios";
		} else {
			
			for (Usuario usuario : controlador.getAllUsers()) {
				if (usuario.getNombre().equals(nombre) && usuario.getEmail().equals(mail)) {
					return  "rol:"+usuario.getRol();
				}
			}
			return "No se encontró";

		}

	}


	public static String Registrarse(String nombre, String mail) {

		UsuarioControlador controlador = new UsuarioControlador();

		if (nombre.length()>3 ) {
			if (mail.length()>3) {
				for (Usuario usuario : controlador.getAllUsers()) {
					if (usuario.getNombre().equals(nombre)) {
						return "Usuario existente";
					}
				}
				controlador.addUser(new Usuario(nombre,mail,1));
				return "Ok";
			} else {
				return "Ingrese un mail valido(Minimo 4 letras)";
			}
		} else {
			return "Ingrese un nombre valido(Minimo 4 letras)";

		}
		
		

	}
}
