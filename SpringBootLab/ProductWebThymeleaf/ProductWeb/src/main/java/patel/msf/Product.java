package patel.msf;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="myproduct")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	private String brand;
	private String madein;
	private float price;

	

//	protected Product(Long id, String name, String brand, String madein, float price) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.brand = brand;
//		this.madein = madein;
//		this.price = price;
//	}


}
