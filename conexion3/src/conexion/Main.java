package conexion;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		
		UsuarioControlador controlar = new UsuarioControlador();
		
		
		String[] opciones = {
				"Agregar usuario","Ver usuarios","Buscar usuario por id","Editar usuario","Eliminar usuario","Salir"
		};
		int opcion=0;
	do {
		
	opcion = JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, opciones, opciones[0]);
		switch (opcion) {
		case 0:
			String nombre = JOptionPane.showInputDialog("Ingrese nombre");
			String mail = JOptionPane.showInputDialog("Ingrese mail");
			controlar.addUser(new Usuario(nombre,mail));		
			break;
		case 1:
			JOptionPane.showMessageDialog(null, controlar.getAllUsers());	
			break;
		case 2:
			Usuario nuevo = BuscarUsuario(controlar);
			JOptionPane.showMessageDialog(null, nuevo);
			break;
		case 3:
			Usuario encontrado = BuscarUsuario(controlar);
			String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de : " + encontrado.getNombre());
			String nuevoEmail = JOptionPane.showInputDialog("Ingrese el nuevo email de : " + encontrado.getEmail());
			encontrado.setEmail(nuevoEmail);
			encontrado.setNombre(nuevoNombre);
			controlar.updateUser(encontrado);
			break;
		case 4:
			Usuario eliminar = BuscarUsuario(controlar);
			controlar.deleteUser(eliminar.getId());
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Salir");
			break;
		default:
			break;
		}
	} while (opcion!=5);
		
	}
	public static Usuario BuscarUsuario(UsuarioControlador controlar) {
		String[] listaUsuarios = new String[controlar.getAllUsers().size()];
		
		
		for (int i = 0; i < listaUsuarios.length; i++) {
			listaUsuarios[i] = Integer.toString(controlar.getAllUsers().get(i).getId());
		}
		String elegido =(String) JOptionPane.showInputDialog(null, "Elija un id", null, 0, null, listaUsuarios, listaUsuarios[0]);
		
		Usuario nuevo = controlar.getUserById(Integer.parseInt(elegido));
		return nuevo;
	}
}