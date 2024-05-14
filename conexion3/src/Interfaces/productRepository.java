package Interfaces;

import java.util.List;

import Modelos.Producto;

public interface productRepository {
	//prototipos de metodos 
    List<Producto> getAllProducts();
    
    Producto getProductById(int id); 
    
    void addProduct(Producto Product); 
    
    void updateProduct(Producto Product); 
    
    void deleteProduct(int id);
}
