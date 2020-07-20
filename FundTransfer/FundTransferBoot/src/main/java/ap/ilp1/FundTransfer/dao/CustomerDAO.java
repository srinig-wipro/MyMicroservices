package ap.ilp1.FundTransfer.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ap.ilp1.FundTransfer.entity.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

	

}
