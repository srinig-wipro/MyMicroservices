package ap.sb.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ap.sb.domain.Product;

@Repository
@Transactional
public interface ProductDao extends JpaRepository<Product, Integer>{

}
