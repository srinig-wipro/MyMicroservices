package com.bank.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
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
@Table(name="mile3_account")
@NamedQuery(name="Employee.findAll", query="SELECT a FROM Account a")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int accountID;
	@Column double balance;

	@ManyToOne    // owning
	Customer customer;
}
