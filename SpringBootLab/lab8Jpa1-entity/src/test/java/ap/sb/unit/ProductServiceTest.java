package ap.sb.unit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import ap.sb.dao.ProductDao;
import ap.sb.domain.Product;
import ap.sb.service.ProductService;

//Note: use of static imports from hamcrest for junit5

@SpringBootTest
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

	private static Product p1;
	private static Product p2;
	private static Product p3;
	private static Product p4;
	private static Product p5;

	@Mock
	private ProductDao productRepo;

	@InjectMocks // auto inject productRepository
	private ProductService productService;// = new ProductService();

	@BeforeAll
	public static void init() {
		p1 = new Product("TV", "sony", "japan", 1987.56f);
		p2 = new Product("Cell Phone", "One+", "China", 1434.78f);
		p3 = new Product("Air Purifier", "Datasun", "Korea", 1568.3f);
		p4 = new Product("TV2", "sony", "japan", 1987.56f);
		p5 = new Product("Cell2", "One+", "China", 1434.78f);	
	}

	// @DisplayName("test1 when empty")
	@Test
	void testA1ReadAllProducts_WhenEmpty() {
		Mockito.when(productRepo.findAll()).thenReturn(Arrays.asList());
		assertEquals(0, productService.readAllProducts().size());
		Mockito.verify(productRepo, Mockito.times(1)).findAll();
	}

	// @DisplayName("test2 fetch all Products")
	@Test
	void testA2ReadAllProducts() {
		Mockito.when(productRepo.findAll()).thenReturn(Arrays.asList(p1, p2, p3));
		assertEquals(3,productService.readAllProducts().size());
		assertEquals(p1,productService.readAllProducts().get(0));
		assertEquals(p2,productService.readAllProducts().get(1));
		assertEquals(p3,productService.readAllProducts().get(2));
		Mockito.verify(productRepo, Mockito.times(4)).findAll();
	}

	@DisplayName("test3 get Product by Id")
	@Test
	void testA3ReadProduct() {
		Mockito.when(productRepo.findById(1)).thenReturn(Optional.of(p1));
		assertThat(productService.readProduct(1), is(p1));
		Mockito.verify(productRepo, Mockito.times(1)).findById(1);

	}

	@Test
	void testA4SaveRecord_1() {
		Mockito.when(productRepo.save(p1)).thenReturn(p1);
		assertThat(productService.saveOrUpdateProduct(p1), is(p1));
		Mockito.verify(productRepo, Mockito.times(1)).save(p1);	
		
		Mockito.when(productRepo.save(p2)).thenReturn(p2);
		assertThat(productService.saveOrUpdateProduct(p2).getName(), is("Cell Phone"));
		Mockito.verify(productRepo, Mockito.times(1)).save(p2);
	}
	
	@Test
	void testA5Update() {
		Mockito.when(productRepo.save(p1)).thenReturn(p1);
		assertThat(productService.saveOrUpdateProduct(p1), is(p1));
		Mockito.verify(productRepo, Mockito.times(1)).save(p1);

		Mockito.when(productRepo.save(p2)).thenReturn(p2);
		assertThat(productService.saveOrUpdateProduct(p2).getName(), is("Cell Phone"));
		Mockito.verify(productRepo, Mockito.times(1)).save(p2);
	}

	@Test
	void testA6FindByBrand() {
		Mockito.when(productRepo.findByBrand("sony")).thenReturn(p1);
		assertThat(productService.findByBrand("sony"), is(p1));
		Mockito.verify(productRepo, Mockito.times(1)).findByBrand("sony");	
	}

	@Test
	void testA7FindByMadein() {
//		Mockito.when(productRepo.findByMadein("Korea")).thenReturn(Arrays.asList( p3));
//		assertEquals(p3,productService.findByMadein("Korea").get(0));
//		Mockito.verify(productRepo, Mockito.times(1)).findByBrand("Korea");
	}

	@Test
	void testA8Delete() {
		productService.deleteProduct(1);
		Mockito.verify(productRepo, Mockito.times(1)).deleteById(1);
	}

}
