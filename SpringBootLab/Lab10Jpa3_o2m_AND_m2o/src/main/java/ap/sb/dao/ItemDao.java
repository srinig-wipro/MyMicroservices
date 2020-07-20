package ap.sb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ap.sb.domain.Item;


@Repository
public interface ItemDao extends JpaRepository<Item,Integer>{

}
