package ap.sb.domain;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/*
 * Using composed column for unique constraints
 * @Table(name="myproduct",uniqueConstraints=@UniqueConstraint(columnNames={"col-A","col-B","col-x"}))
 * 
 *  Using Sequence
 *  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productid_generator")
 *  @SequenceGenerator(name="productid_generator", sequenceName = "productid_seq", initialValue=1001, allocationSize=1000)
 */


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "myproductm20")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Size(max = 100)
	private String brand;
	@Size(max = 100)
	private String madein;
	private float price;
	
	@ManyToOne 
	@JoinColumn(name="CATEGORY_ID")
	private Category category;

	public Product(String name, String brand, String madein, float price) {
		super();
		this.name = name;
		this.brand = brand;
		this.madein = madein;
		this.price = price;
	}
}
