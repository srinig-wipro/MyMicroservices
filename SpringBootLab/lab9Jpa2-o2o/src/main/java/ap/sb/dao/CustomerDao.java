package ap.sb.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ap.sb.domain.Customer;

@Repository
@Transactional
public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
