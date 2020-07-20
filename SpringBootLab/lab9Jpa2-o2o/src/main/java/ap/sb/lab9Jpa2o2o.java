package ap.sb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ap.sb.dao.CustomerDao;
import ap.sb.dao.ShippingAddressDao;
import ap.sb.domain.Customer;
import ap.sb.domain.ShippingAddress;

@SpringBootApplication
public class lab9Jpa2o2o {
	
	@Autowired
	CustomerDao custRepo;
	
	@Autowired
	ShippingAddressDao addressRepo;

	public static void main(String[] args) {
		SpringApplication.run(lab9Jpa2o2o.class, args);
		System.out.println("######## Up & Ready #######");
	}
	
	@Bean
	CommandLineRunner demoSetUp() {
		return(args)->{
			System.out.println("++++++++++++++++++");
			Customer customer1=new Customer("myname");
			ShippingAddress address=new ShippingAddress("address");
			
			customer1.setShippingAddress(address);
			address.setCustomer(customer1);

			Customer dbCustomer=custRepo.save(customer1);
			System.out.println("######## : "+dbCustomer.getName());
			System.out.println(dbCustomer+"  ^^^^^^^^^   "+dbCustomer.getShippingAddress());
			
			List<ShippingAddress> dbAddresses=addressRepo.findAll();
			System.out.println(dbAddresses+" !!!!!!!!!!");	
		};
	}
}
