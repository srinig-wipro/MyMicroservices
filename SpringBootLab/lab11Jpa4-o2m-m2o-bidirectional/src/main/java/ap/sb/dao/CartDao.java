package ap.sb.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ap.sb.domain.Cart;




@Repository
@Transactional
public interface CartDao extends JpaRepository<Cart, Integer>{

}
