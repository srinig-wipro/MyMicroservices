package ap.sb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import patel.msf.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findByBrand(String brandName);
	List<Product> findByMadein(String madein);

	
}
