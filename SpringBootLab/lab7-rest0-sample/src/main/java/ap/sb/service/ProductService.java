package ap.sb.service;

import java.util.List;

import ap.sb.domain.Product;

public interface ProductService {
	Product findById(int id);
	Product findByName(String name);
	
	Product saveProduct(Product product);
	void updateProduct(Product product);
	
	void deleteProductById(int id);
	List<Product> findAllProducts();
	void deleteAllProducts();
	boolean isProductExist(Product product);
	String getMessage();
}
