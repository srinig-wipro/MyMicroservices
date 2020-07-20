package ap.sb.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ap.sb.domain.ShippingAddress;

@Repository
@Transactional
public interface ShippingAddressDao extends JpaRepository<ShippingAddress, Integer>{

}
