package ap.sb;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import ap.sb.dao.CartDao;
import ap.sb.dao.ItemsDao;
import ap.sb.domain.Cart;
import ap.sb.domain.Item;



@SpringBootApplication
public class Lab3o2mm2oBidirectional {
	@Autowired
	private CartDao cartRepo;

	@Autowired
	private ItemsDao itemsRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Lab3o2mm2oBidirectional.class, args);
		System.out.println("###### Up & Ready ######");
	}
	
	@Bean
	@Transactional
	CommandLineRunner demoSetup() {
		return(args)->{
			System.out.println("!!!!!!!!!!!!!!!!!!");
			
			Cart c1 = new Cart("MyCartPrashanth");
			Cart c2 = new Cart("MyCartAvinash");

			Set<Item> c1items = new HashSet<Item>();
			Item i1 = new Item("TV", 10, 1, c1);
			Item i2 = new Item("CellPhone", 10, 1, c1);
			c1items.add(i1);
			c1items.add(i2);
			c1.setItems(c1items);

			Set<Item> c2items = new HashSet<Item>();
			Item i3 = new Item("Bag", 10, 1, c2);
			Item i4 = new Item("Pen", 20, 2, c2);
			c2items.add(i3);
			c2items.add(i4);
			c2.setItems(c2items);

			cartRepo.save(c1);
			cartRepo.save(c2);
			
			List<Cart> carts=cartRepo.findAll();
			for(Cart c:carts) {
				System.out.println("***** Cart Details: "+c.getName()+" **: "+c.getItems());
			}
			List<Item> items=itemsRepo.findAll();
			for(Item i:items) {
				System.out.println(" @@ Items : "+i+"cart details: "+ i.getCart());
			}
			
		};
	}

}
