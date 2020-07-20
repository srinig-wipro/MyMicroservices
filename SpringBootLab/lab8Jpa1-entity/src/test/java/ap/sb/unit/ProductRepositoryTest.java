package ap.sb.unit;



import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ap.sb.dao.ProductDao;
import ap.sb.domain.Product;


@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ProductRepositoryTest {	
	private static Product p1;
    private static Product p2;
    private static Product p3;
    private static Product p4;
    private static Product p5;
    
    @Autowired
	ProductDao productRepo;
    
    @BeforeAll
    public static void init() {
		 p1 = new Product(1,"TV", "sony", "japan", 1987.56f); // preloaded - id value defined
		 p2 = new Product(2,"Cell Phone", "One+", "China", 1434.78f); // // preloaded- id value defined
		 p3 = new Product(3,"Air Purifier", "Datasun", "Korea", 1568.3f);// preloaded- id value defined
		 p4 = new Product("TV2", "sony", "japan", 1987.56f);
		 p5 = new Product("Cell2", "One+", "China", 1434.78f);		
    }

//	@Test
	void testA1FindAllProducts() {
		System.out.println("****************************");
		List<Product> products=productRepo.findAll();	
		
		assertEquals(3,products.size());
		
		List<Product> refProducts=new ArrayList<Product>();
		refProducts.add(p1);
		refProducts.add(p2);
		refProducts.add(p3);
		assertIterableEquals(refProducts, products);		
		assertEquals(refProducts.get(0),products.get(0));		
		//assertSame(E,A) or assertNotSame(E,A) validates for object references
	}
	
	//@Test
	void testA2FindById() {		
		Optional<Product> foundProduct=productRepo.findById(1); 
		assertTrue(foundProduct.isPresent());
		assertEquals(p1, foundProduct.get());
		
		Optional<Product> emptyProduct=productRepo.findById(4); 
		assertTrue(emptyProduct.isEmpty());		
	}
	
	//@Test
	void testA3FindByBrand() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Product  foundProduct= productRepo.findByBrand("sony");
		assertEquals(p1,foundProduct);
		
		Product  nemptyProduct= productRepo.findByBrand("NOT_PRESNT");
		assertNull(nemptyProduct);		
	}

	//@Test
	void testA4FindByMadein() {
	List<Product>  foundProducts= productRepo.findByMadein("Korea");
	assertEquals(1,foundProducts.size());		
	assertEquals(p3,foundProducts.get(0));
	}
	
	//@Test
	void testA5SaveRecord() {
		Product createdProduct =productRepo.save(p4);
		System.out.println(createdProduct+" #######");
		List<Product> products=productRepo.findAll();		
		assertEquals(4,products.size());	
	}
}

//
//@Test
//void testA6EditRecordById() {		
//}
//
//@Test
//void testA7EditRecordByName() {		
//}
//
//@Test
//void testA8RemoveRecordById() {		
//}

