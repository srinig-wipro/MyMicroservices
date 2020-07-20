package ap.sb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import patel.msf.entity.Product;
import patel.msf.myexceptions.BadResourceException;
import patel.msf.myexceptions.ResourceAlreadyExistsException;
import patel.msf.myexceptions.ResourceNotFoundException;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	private boolean existsById(Long id) {
		return productRepo.existsById(id);
	}

	public List<Product> listAllRecords() {

		return productRepo.findAll();
	}

	public Product save(Product product) throws ResourceAlreadyExistsException, BadResourceException {
		// repo.save(product);

		if (!StringUtils.isEmpty(product.getName())) {
			if (product.getId() != null && existsById(product.getId())) {
				throw new ResourceAlreadyExistsException("product with id: " + product.getId() + " already exists");
			}
			return productRepo.save(product);
		} else {
			BadResourceException exc = new BadResourceException("Failed to save product");
			exc.addErrorMessage("product is null or empty");
			throw exc;
		}

	}

	public Product findById(long id) throws ResourceNotFoundException {
		Product product = productRepo.findById(id).orElse(null);
		if (product == null) {
			throw new ResourceNotFoundException("Cannot find product with id: " + id);
		} else
			return product;
	}

	public void update(Product product) throws ResourceNotFoundException, BadResourceException {
		if (!StringUtils.isEmpty(product.getName())) {
			if (!existsById(product.getId())) {
				throw new ResourceNotFoundException("Cannot find product with id: " + product.getId());
			}
			productRepo.save(product);
		} else {
			BadResourceException exc = new BadResourceException("Failed to save product");
			exc.addErrorMessage("product is null or empty");
			throw exc;
		}
	}

	public void delete(long id) throws ResourceNotFoundException {
		if (!existsById(id)) {
			throw new ResourceNotFoundException("Cannot find product with id: " + id);
		} else {
			productRepo.deleteById(id);
		}
		
	
	}
}
