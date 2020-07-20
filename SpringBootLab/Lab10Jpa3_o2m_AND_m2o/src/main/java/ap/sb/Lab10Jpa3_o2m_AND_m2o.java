package ap.sb;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ap.sb.dao.CartDao;
import ap.sb.dao.CategoryDao;
import ap.sb.dao.ItemDao;
import ap.sb.dao.ProductDao;
import ap.sb.domain.Cart;
import ap.sb.domain.Category;
import ap.sb.domain.Item;
import ap.sb.domain.Product;


@SpringBootApplication
public class Lab10Jpa3_o2m_AND_m2o {
	
	@Autowired
	ProductDao prodRepo;
	
	@Autowired
	CategoryDao categoryRepo;
	
	@Autowired
	CartDao cartRepo;
	
	@Autowired
	ItemDao itemRepo;

	public static void main(String[] args) {
		SpringApplication.run(Lab10Jpa3_o2m_AND_m2o.class, args);
		System.out.println("##### Up & Ready ####");
	}
	
	@Bean
	CommandLineRunner demoSetUpO2M() {
		return(args)->{
			System.out.println("++++++++++++++++++");
			
			Cart cart1=new Cart("cart1");
			Cart cart2=new Cart("cart2");
			
			Item itemA=new Item("itemA");
			Item itemB=new Item("itemB");
			Item itemC=new Item("itemC");

			Set<Item> items=new HashSet<Item>();
			items.add(itemA);
			items.add(itemB);
			items.add(itemC);
			cart1.setItems(items);
			
			Cart dbCart1=cartRepo.save(cart1);			
			System.out.println(dbCart1+"#######: "+dbCart1.getName());
		};
	}
	
	@Bean
	CommandLineRunner demoSetUpM2O() {
		return(args)->{
			System.out.println("++++++++++++++++++");
			Category category = new Category("Electronics");
		    
		    Product pc = new Product("PC", "DELL", "USA", 2300.234f);	
		    pc.setCategory(category);
		    Product laptop = new Product("laptop", "Apple", "USA", 4321.43f);	
		    laptop.setCategory(category);
		    Product phone = new Product("phone", "Apple", "USA", 4321.43f);
		    phone.setCategory(category);
		    Product tablet = new Product("iPad", "Apple", "USA", 4321.43f);
		    tablet.setCategory(category);
		     
		  Category dbCategory= categoryRepo.save(category);
		  prodRepo.save(pc);
		  prodRepo.save(laptop);
		  prodRepo.save(phone);
		  prodRepo.save(tablet);
		  System.out.println("dbCategory--#### : "+dbCategory);
		  List<Product> dbProducts=prodRepo.findAll();
		  System.out.println("dbProducts--#### : "+dbProducts);	
		};
	}
}
