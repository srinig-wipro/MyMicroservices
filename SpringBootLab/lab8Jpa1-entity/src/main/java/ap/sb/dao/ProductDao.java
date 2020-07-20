package ap.sb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ap.sb.domain.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

	Product findByBrand(String brandName); // findBy<NON-PrimaryKey>
	List<Product> findByMadein(String madein);// findBy<NON-PrimaryKey>

	@Modifying
	@Query("UPDATE Product p SET p.name = :name WHERE p.id = :id")
	int updateNameUsingId(@Param("id") int id, @Param("name") String name);

	@Modifying
	@Query("UPDATE Product p SET p.name = :name WHERE p.name = :basename")
	int replaceProductName(@Param("name") String name, @Param("basename") String basename);

	@Modifying
	@Query("DELETE Product p WHERE p.name = :name")
	int deleteProductsByName(@Param("name") String name);

}
