package ap.ilp1.FundTransfer.dao;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ap.ilp1.FundTransfer.entity.Account;


@Repository

public interface AccountDAO extends JpaRepository<Account, Integer>{

	

}
