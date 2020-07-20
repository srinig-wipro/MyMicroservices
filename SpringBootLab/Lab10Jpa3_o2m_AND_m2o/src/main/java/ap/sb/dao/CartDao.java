package ap.sb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ap.sb.domain.Cart;
import ap.sb.domain.Category;

@Repository
public interface CartDao extends JpaRepository<Cart,Integer>{

}
