package ap.sb.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ap.sb.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service("productService")
class ProductServiceImpl implements ProductService {
	
	static int num=1;
	@Value("${app.product.welcomemessage}")
	private String welcomeMessage;

    //  Using two hashmaps in order to provide performance of O(1) while fetching products
    private static HashMap<Integer, Product> products = new HashMap<>();
    private static HashMap<String, Integer> idNameHashMap = new HashMap<>();

    public String getMessage() {
    	return welcomeMessage;
    	
    }

    public List<Product> findAllProducts() {
        // Pagination should be added...
        return new ArrayList<>(products.values());
    }

    public Product findById(int id) {    	  	
            return products.get(id);
    }

    public Product findByName(String name) {

        if (idNameHashMap.get(name) != null){
            return products.get(idNameHashMap.get(name));
        }

        return null;
    }

    public Product saveProduct(Product product) {
        synchronized (this) {    //  Critical section synchronized
        	product.setId(getGeneratedID());
            products.put(product.getId(), product);
            idNameHashMap.put(product.getName(), product.getId());
            return product;
        }
    }

    public void updateProduct(Product product) {
        synchronized (this) {    //  Critical section synchronized
            products.put(product.getId(), product);
            idNameHashMap.put(product.getName(), product.getId());
        }
       
    }

    public void deleteProductById(int id) {
        synchronized (this) {    //  Critical section synchronized
            idNameHashMap.remove(products.get(id).getName());
            products.remove(id);
        }
    }

    public boolean isProductExist(Product product) {
        return findByName(product.getName()) != null;
    }

    public void deleteAllProducts() {
        products.clear();
    }
    
    private int getGeneratedID(){
    	return ++num;
    }

}
