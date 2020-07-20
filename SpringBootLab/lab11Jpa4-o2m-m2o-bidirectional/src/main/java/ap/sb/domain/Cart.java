package ap.sb.domain;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
//@JsonInclude(Include.NON_EMPTY)
@Entity
@Table(name="cartbidirectional")
public class Cart implements Serializable {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="cart_id")
	    private int id;
	     
	    @Column(name="total")
	    private double total;
	     
	    @Column(name="name")
	    private String name;
	     
	    @OneToMany(mappedBy="cart",cascade=CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	    private Set<Item> items;
	    
	    public Cart(String name) {
			super();			
			this.name = name;			
		}

		public Cart(double total, String name) {
			super();
			this.total = total;
			this.name = name;			
		}
}
