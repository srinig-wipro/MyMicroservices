package ap.sb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;



@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {

	private Long id;
	
	private String name;
	

	private String brand;
	
	
	private String madein;
	
	private float price;
	
	public Product(String name, String brand, String madein, float price) {
		super();
		
		this.name = name;
		this.brand = brand;
		this.madein = madein;
		this.price = price;
	}

}
