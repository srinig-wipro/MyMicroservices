package ap.sb.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Using composed column for unique constraints
 * @Table(name="myproduct",uniqueConstraints=@UniqueConstraint(columnNames={"col-A","col-B","col-x"}))
 * 
 *  Using Sequence
 *  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productid_generator")
 *  @SequenceGenerator(name="productid_generator", sequenceName = "productid_seq", initialValue=1001, allocationSize=1000)
 */


//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productm2m")
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private String name;	
	@Size(max = 100)
	private String brand;	
	@Size(max = 100)
	private String madein;	
	private float price;
	
//	@Embedded
//	Specification spec;
	
	//@ToString.Exclude //essential to avoid stack overflow error - cyclic dependency
	@ManyToMany(mappedBy="products",fetch = FetchType.LAZY)//,cascade =CascadeType.ALL
    private Set<Store> stores=new HashSet<Store>();
	
	public Product(String name, String brand, String madein, float price) {
		super();		
		this.name = name;
		this.brand = brand;
		this.madein = madein;
		this.price = price;		
	}

	public Product(String name) {
		super();
		this.name = name;
	}
}
