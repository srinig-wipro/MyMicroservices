package ap.sb.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_generator")
//	@SequenceGenerator(name="store_generator", sequenceName = "store_seq", initialValue=101, allocationSize=100)
//    @Column(name="id",updatable = false, nullable = false)
	private int id;	
	String name;
	
	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Set<Inventory> inventoryDetails = new HashSet<Inventory>();

	public Store(String name) {
		super();
		this.name = name;
	}
	
	public Store(String name, Inventory... inventoryDetails) {
        this.name = name;
        for(Inventory bookPublisher : inventoryDetails) bookPublisher.setStore(this);
        this.inventoryDetails = Stream.of(inventoryDetails).collect(Collectors.toSet());
    }	
}
