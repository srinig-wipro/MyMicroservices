package ap.sb.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {	
	@Autowired
	private DataSource dataSource;

	public String getProductDao() {
		System.out.println("Data source: "+dataSource);
		return ".. Product Dao executed ...";
	}
}
