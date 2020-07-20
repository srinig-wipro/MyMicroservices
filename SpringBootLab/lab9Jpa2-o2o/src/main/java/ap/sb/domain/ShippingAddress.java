package ap.sb.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "myaddress6may")
public class ShippingAddress implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	String address;

	// @ToString.Exclude // Note required to avoid cyclic to string operation while
	// printing fetch data
	@JsonManagedReference
	@OneToOne(mappedBy = "shippingAddress") // Bidirectional One-to-One Associations
											// Note: Cascade on both side leads to cyclic dependency
	private Customer customer;

	public ShippingAddress(String address) {
		super();
		this.address = address;
	}
}
