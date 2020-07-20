package ap.sb;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import ap.sb.controller.ProductController;


@SpringBootApplication
public class Lab3Layers {

	@Autowired
	ProductController productController;

	@Bean
	CommandLineRunner demoSpecializedComponents() {
		return (args) -> {
			System.out.println(productController.getProductController());
			System.out.println();
	
		};
	}	

	public static void main(String[] args) {
		SpringApplication.run(Lab3Layers.class, args);
	}
}
