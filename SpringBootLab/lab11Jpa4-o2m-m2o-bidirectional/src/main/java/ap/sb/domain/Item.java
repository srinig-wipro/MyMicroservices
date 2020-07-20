package ap.sb.domain;


import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="itembidirectional")
public class Item implements Serializable{
	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="id")
	    private int id;
	     
	    @Column(name="item_id")
	    private String itemId;
	     
	    @Column(name="item_total")
	    private double itemTotal;
	     
	    @Column(name="quantity")
	    private int quantity;
	     
	    @ToString.Exclude //essential to avoid stack overflow error - cyclic dependency
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="fk_cart_id", nullable=false)
	    private Cart cart;
		public Item(String itemId, double itemTotal, int quantity, Cart cart) {
			super();
			this.itemId = itemId;
			this.itemTotal = itemTotal;
			this.quantity = quantity;
			this.cart = cart;
		}
}
