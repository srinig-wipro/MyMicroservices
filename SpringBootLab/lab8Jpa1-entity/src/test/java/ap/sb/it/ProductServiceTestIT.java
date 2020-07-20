package ap.sb.it;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ap.sb.dao.ProductDao;
import ap.sb.domain.Product;
import ap.sb.service.ProductService;

//Preferences > Java > Editor > Content Assist > Favorites..add new types to get static imports

//@ExtendWith(SpringExtension.class)

@SpringBootTest
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class ProductServiceTestIT {

	private static Product p1;
	private static Product p2;
	private static Product p3;
	private static Product p4;
	private static Product p5;

	@Autowired
	ProductService proService;

	@Autowired
	ProductDao productRepo;

	@Autowired
	EntityManager testEM;

	@BeforeAll
	public static void init() {
		p1 = new Product("TV", "sony", "japan", 1987.56f);
		p2 = new Product("Cell Phone", "One+", "China", 1434.78f);
		p3 = new Product("Air Purifier", "Datasun", "Korea", 1568.3f);
		p4 = new Product("TV2", "sony", "japan", 1987.56f);
		p5 = new Product("Cell2", "One+", "China", 1434.78f);
	}

	@Test
	void testA1_it_ReadAllProducts_whenEmpty() {
		Iterable<Product> products = proService.readAllProducts();
		assertThat(products).isEmpty(); // assertJ
	}

	@Test
	void testA2_it_SaveOrUpdateProduct() {
		Product dbP1 = proService.saveOrUpdateProduct(p1);
		Product dbP2 = proService.saveOrUpdateProduct(p2);
		assertEquals(2, proService.readAllProducts().size());
		assertThat(dbP1).hasFieldOrPropertyWithValue("name", "TV");
		assertThat(dbP2).hasFieldOrPropertyWithValue("madein", "China");
	}

	@Test
	void testA3_it_ReadAllProducts() {
		assertEquals(2, proService.readAllProducts().size());
	}

	@Test
	void testA4_it_ReadProductById() {
		Optional<Product> foundProduct = productRepo.findById(1);
		System.out.println("############  *********** " + foundProduct);
		foundProduct.ifPresent(f -> {
			System.out.println(f + "---$$$$-- " + f.getName());
		});
		assertEquals(2, proService.readAllProducts().size());
	}

	@Test
	void testA5_it_FindByBrand() {
		Product foundProduct = proService.findByBrand("sony");
		assertEquals(p1, foundProduct);

		Product nemptyProduct = proService.findByBrand("NOT_PRESNT");
		assertNull(nemptyProduct);
	}

	@Test
	void testA6_it_FindByMadein() {
		assertEquals(2, proService.readAllProducts().size());
		List<Product> foundProducts = productRepo.findByMadein("japan");
		assertThat(foundProducts).hasSize(1);
		// assertEquals(p1,foundProducts.get(0));
	}

}
