package ap.sb;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ap.sb.dao.ProductDao;
import ap.sb.dao.StoreDao;
import ap.sb.domain.Product;
import ap.sb.domain.Store;

@SpringBootApplication
public class Lab3Jpa5m2m {

	@Autowired
	ProductDao productRepo;

	@Autowired
	StoreDao storeRepo;

	public static void main(String[] args) {
		SpringApplication.run(Lab3Jpa5m2m.class, args);
		System.out.println("###### Up & Ready #######");
	}

	@Bean
	@Transactional
	CommandLineRunner demoSetup() {
		return (args) -> {
			System.out.println("!!!!!!!!!!!!!!!!!!");

			Product p1 = new Product("p1");
			Product p2 = new Product("p2");
			Product p3 = new Product("p3");

			Store s1 = new Store("s1");
			Store s2 = new Store("s2");
			Store s3 = new Store("s3");
			
			p1.getStores().add(s1);p2.getStores().add(s1);
			p2.getStores().add(s2);p3.getStores().add(s1);
			p3.getStores().add(s2);p3.getStores().add(s3);
			
			s1.getProducts().add(p1);s1.getProducts().add(p2);
			s1.getProducts().add(p3);
			
			s2.getProducts().add(p2);s2.getProducts().add(p3);
			s3.getProducts().add(p3);			

			productRepo.save(p1);
			productRepo.save(p2);
			productRepo.save(p3);
			
			List<Product> products=productRepo.findAll();
			System.out.println("#### :  "+products);
		};
	}
}
