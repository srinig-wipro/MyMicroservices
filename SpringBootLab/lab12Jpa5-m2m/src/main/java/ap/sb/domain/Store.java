package ap.sb.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "storem2m")
public class Store implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	String name;
	
	 //@ToString.Exclude //essential to avoid stack overflow error - cyclic dependency
	@ManyToMany(fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    @JoinTable(name = "store_product",
           joinColumns = { @JoinColumn(name = "fk_store") },
           inverseJoinColumns = { @JoinColumn(name ="fk_product") })
    private Set<Product> products = new HashSet<Product>();

	public Store(String name) {
		super();
		this.name = name;
	}
}
