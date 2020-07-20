package ap.sb;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ap.sb.component.Cost;
import ap.sb.configuration.DemoManagerConfiguration;

@SpringBootApplication
public class Lab2BootUsingComponents {
	
	@Autowired
	@Qualifier("newcustomercost")
	Cost newcustomercost;

	@Resource
	@Qualifier("promotioncost")
	Cost promotioncost;

	@Resource
	@Qualifier("regularcost")
	Cost regualarcost;

	@Bean
	CommandLineRunner demoComponents() {
		return (args) -> {
			System.out.println("##########");
			System.out.println(newcustomercost.getDiscountPercentage());
			System.out.println(promotioncost.getDiscountPercentage());
		};
	}

	@Bean
	CommandLineRunner demoConfiguration(DemoManagerConfiguration regularCostService) {
		return (args) -> {
			System.out.println("!!!!!!!!!!!!");
			System.out.println(regularCostService.managerService().getServiceName());
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab2BootUsingComponents.class, args);
	}
}
