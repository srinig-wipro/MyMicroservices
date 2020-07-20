/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :
 *
 * File Name       : Account.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :Mar 7, 2017
 * 
 */
package ap.ilp1.FundTransfer.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author - avinash.patel@wipro.com
 * Date : Mar 7, 2017
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="Account")
public class Account {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int id;
	
	double balance;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
	Customer customer;


	
	public Account(Customer customer, double balance) {
		super();
		
		this.customer = customer;
		this.balance = balance;
	}



}
