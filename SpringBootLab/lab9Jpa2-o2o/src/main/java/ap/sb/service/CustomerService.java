package ap.sb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ap.sb.domain.Customer;

@Service
@Transactional
public class CustomerService {
	
	public Customer readCustomer(int id) {
		return null;
	}
	public List<Customer> readAllCustomers() {
		return null;
	}
	public Customer editCustomer(Customer customer) {
		return null;
	}
	public boolean deleteCustomer(int id) {
		return false;
	}
	public int deleteAllCustomers() {
		return 0;
	}
	public Customer createCustomer(Customer customer) {
		return null;
	}

}
