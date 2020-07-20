package ap.sb.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ap.sb.domain.Category;

@Repository
@Transactional
public interface CategoryDao extends JpaRepository<Category,Integer>{

}
