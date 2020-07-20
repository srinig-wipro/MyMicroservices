-- oracle syntax
create table account(
	 accountID number primary key, 
	 balance number,
	customerid REFERENCES customer (customerid)
	);

create table customer(
 customerid number primary key,
 name varchar2(20)
);