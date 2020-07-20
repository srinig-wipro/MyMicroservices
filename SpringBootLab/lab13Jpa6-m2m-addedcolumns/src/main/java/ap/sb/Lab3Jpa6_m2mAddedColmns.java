package ap.sb;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import ap.sb.dao.ProductDao;
import ap.sb.dao.StoreDao;
import ap.sb.domain.Inventory;
import ap.sb.domain.Product;
import ap.sb.domain.Store;

@SpringBootApplication
public class Lab3Jpa6_m2mAddedColmns {
	
	@Autowired
	ProductDao productRepo;

	@Autowired
	StoreDao storeRepo;
	
//	@Autowired
//	InventoryDao inventoryRepo;



	public static void main(String[] args) {
		SpringApplication.run(Lab3Jpa6_m2mAddedColmns.class, args);
		System.out.println("##### Up & Ready ####");
	}
	
	@Bean
	CommandLineRunner demoSetup() {
		return(args)->{
			System.out.println("!!!!!!!!!!!!!!!!!!");
			
			Product p1 = new Product("TV", "sony", "japan", 1987.56f);
			Product p2 = new Product("Cell Phone", "One+", "China", 1434.78f);
			Product p3 = new Product("Air Purifier", "Datasun", "Korea", 1568.3f);
			
			productRepo.saveAll(Arrays.asList(p1, p2, p3));
			
			Store s1 = new Store("s1",new Inventory(p1,123), new Inventory(p2,214));
			Store s2 = new Store("s2",new Inventory(p1,123));
			
//			storeRepo.save(s1);
//			storeRepo.save(s2);
			storeRepo.saveAll(Arrays.asList(s1, s2));

			List<Product> products=productRepo.findAll();
			for(Product p:products) {
			System.out.println(p.getName()+"***"+p.getInventoryDetails());
			p.getInventoryDetails().forEach(i -> System.out.println(i.getStore().getName()+" "+i.getQuantity()));
			//p.getInventoryDetails().forEach(System.out::println);
			}
			
		};
	}

}
