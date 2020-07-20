package ap.sb.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "mycart02m")
public class Cart implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;	
	
	@OneToMany(cascade = CascadeType.ALL) //(mappedBy="cart")
	@JoinColumn(name ="fk_cart_id")
	private Set<Item> items=new HashSet<Item>();

	public Cart(String name) {
		super();
		this.name = name;
	}
}
