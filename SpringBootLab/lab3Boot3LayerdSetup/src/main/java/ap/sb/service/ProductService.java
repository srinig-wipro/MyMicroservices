package ap.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ap.sb.dao.ProductDao;

@Service
public class ProductService {	
	@Autowired
	ProductDao productDao;
	
	public String getProductService() {
		System.out.println(productDao.getProductDao());
		return ".. Product Service executed ...";
	}
}
