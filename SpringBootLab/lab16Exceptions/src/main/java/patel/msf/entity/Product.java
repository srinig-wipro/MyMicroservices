package patel.msf.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.RequiredArgsConstructor;


//@Pattern(regexp ="^\\+?[0-9. ()-]{7,25}$", message = "Phone number")
//@Size(max = 25)

@Entity
@Data
@RequiredArgsConstructor
@Table(name="myproduct")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	 @Size(max = 100)
	private String brand;
	 @Size(max = 100)
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
