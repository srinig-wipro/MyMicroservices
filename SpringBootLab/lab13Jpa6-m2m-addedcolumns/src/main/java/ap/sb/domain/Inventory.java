package ap.sb.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="inventorym2madded")
public class Inventory implements Serializable{
	@Id
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn //(name="product_id")
	Product product;
	
	@Id
	@ManyToOne (fetch = FetchType.EAGER) 
	@JoinColumn //(name="store_id")
	Store store;
	
	private int quantity;

	public Inventory(Product product, int quantity) {
		super();
		this.product = product;		
		this.quantity = quantity;
	}
}
