package ap.sb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ap.sb.dao.ProductDao;
import ap.sb.domain.Product;

@SpringBootApplication
public class Lab8Jpa1_entity {
	
	@Autowired
	ProductDao productDao;
	

	public static void main(String[] args) {
		SpringApplication.run(Lab8Jpa1_entity.class, args);
	}
	
	
	@Bean
	CommandLineRunner myDemo() {
		return (args)->{
			System.out.println("##############");
			
			Product createdProduct=productDao.save(new Product("demo", "sony", "japan", 1987.56f));
			
			System.out.println(createdProduct+"!!!!!!!!!!!");
			
		};
	}

}
