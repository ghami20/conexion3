package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interfaces.productRepository;
import Modelos.Producto;
import Modelos.Usuario;

public class ProductoControlador implements productRepository{
	private final Connection connection;

    public ProductoControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

	@Override
	public List<Producto> getAllProducts() {
		 List<Producto> products = new ArrayList<>();
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `products`");
	            ResultSet resultSet = statement.executeQuery();
	       
	            
	            while (resultSet.next()) {
	            	Producto product = new Producto(resultSet.getInt("id"),resultSet.getString("nombre"),resultSet.getDouble("precio"));
	            	products.add(product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return products;
	}

	@Override
	public Producto getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(Producto Product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(Producto Product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
	}
}
