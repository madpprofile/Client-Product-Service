package br.cefet.aps.cfs.control;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.cefet.aps.cfs.model.Database;
import br.cefet.aps.cfs.model.Product;

abstract class ProductServices {
	
	void insertProduct(Long id, String name, Long quantity){
		Database db = Database.getInstance();
		db.insertProduct(newProduct(id, name, quantity));
	}
	
	void updateProduct(Long id, Long newId, String newName, Long newQuantity){
		Database db = Database.getInstance();
		db.updateProduct(id, newProduct(newId, newName, newQuantity));
	}
	
	void deleteProduct(Long id){
		Database db = Database.getInstance();
		db.deleteProduct(id);
	}
	
	List<Product> listProducts(){
		Database db = Database.getInstance();
		Map<Long, Product> products = db.getProducts();
		List<Product> productsList = products.entrySet().stream()
				.map(id -> id.getValue()).collect(Collectors.toList());
		return productsList;
	}

	abstract Product newProduct(Long id, String name, Long quantity);
	
}
