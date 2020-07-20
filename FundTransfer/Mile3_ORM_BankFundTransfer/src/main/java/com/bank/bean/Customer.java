package com.bank.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="mile3_customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int customerID;
	String name;
	
	@OneToMany(mappedBy = "customer", 
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER) // owned
	Set<Account> accounts;
	//=new HashSet<Account>();

}
