package ap.sb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ap.sb.dao.ProductDao;
import ap.sb.domain.Product;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductDao proDao;

	public Product readProduct(int id) {
		Optional<Product> foundProduct=proDao.findById(id);
		System.out.println("############  *********** " + foundProduct);
		foundProduct.ifPresent(f -> {
			System.out.println(f + "---$$$$-- " + f.getBrand());
		});
		
		return foundProduct.get();
	}
	
	public List<Product> readAllProducts() {
//		proDao.findAll();
//		proDao.findAll();
//		proDao.findAll();
		return proDao.findAll();
	}
	
	/* 
	 * By default, Spring inspects the Id-Property (@Id) of the entity, to figure out if the entity is new or not. 
	 * If the identifier property is null, then the entity is treated as new, else not new.
	 */
	public Product saveOrUpdateProduct(Product product) {
		
//		Optional<Product> foundOptionlProduct = proDao.findById(product.getId()); ////to get optional product
//		Product foundProduct = proDao.findById(product.getId()).get(); //to get product using findbyid
//		Product dbProduct = productRepo.findById(id).orElse(null);
		
		return proDao.save(product);
	}
	

	public void deleteProduct(int id) {
		
		proDao.deleteById(id);
	}
	
	public Product findByBrand(String brandName) {
		// findBy<NON-PrimaryKey>
		return proDao.findByBrand(brandName);
	}

	public List<Product> findByMadein(String madein){
		// findBy<NON-PrimaryKey>
		List<Product> products= (List<Product>) proDao.findByBrand(madein);
		System.out.println("%%%%%%%"+products);
		return products;
	}
	
	public int editProductNameUsingId(int id,String name) {
		return proDao.updateNameUsingId(id,name);
	}
	
	public int findAndReplaceProductName(String oldName, String revisedName) {
		return proDao.replaceProductName(revisedName,oldName);
	}
	
	public int findAndReplaceProductPrice(int factor) {
		return 0;//proDao.findAndReplaceProductPrice(factor);
	}
	
	public int deleteProductsByName(String name) {
		return proDao.deleteProductsByName(name);
	}
	
}
