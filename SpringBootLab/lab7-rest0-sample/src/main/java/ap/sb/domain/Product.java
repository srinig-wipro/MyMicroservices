package ap.sb.domain;

import java.io.Serializable;


import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable{

	private int id;

	private String name;

	@Size(max = 10)
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
