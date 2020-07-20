package ap.sb;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import patel.msf.entity.Product;
import patel.msf.myexceptions.BadResourceException;
import patel.msf.myexceptions.ResourceAlreadyExistsException;
import patel.msf.myexceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductService productService;

	@Value("${app.indexpage}")
	private String indexPage;

	@Value("${app.getproducts}")
	private String getProducts;

	@GetMapping("/")
	public ModelAndView viewHomePage() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Product> listProducts = productService.listAllRecords();
		model.put(getProducts, listProducts);
		model.put("msg", "Welcome !!!  Product List");
		return new ModelAndView(indexPage, model);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<Product> readProductById(@PathVariable("id") int id) throws ResourceNotFoundException {

		try {
			Product product = productService.findById(id);
			return ResponseEntity.ok(product); // return 200, with json body
		} catch (ResourceNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // return 404, with null body
		}

	}

	@GetMapping("/readall")
	public List<Product> readAllProducts() {
		return productService.listAllRecords();
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> createRecord(@Valid @RequestBody Product product) throws URISyntaxException {

//		productService.save(product);
//		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
		try {
			Product newProduct = productService.save(product);
			return ResponseEntity.created(new URI("/api/products/create" + newProduct.getId())).body(product);
		} catch (ResourceAlreadyExistsException ex) {

			logger.error(ex.getMessage());// log exception first, then return Conflict (409)
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (BadResourceException ex) {

			logger.error(ex.getMessage());// log exception first, then return Bad Request (400)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@PutMapping(value = "/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Product> updateRecord(@PathVariable long id, @RequestBody Product product) {

		try {
			product.setId(id);
			productService.update(product);
			return ResponseEntity.ok().build();
		} catch (ResourceNotFoundException ex) {
			// log exception first, then return Not Found (404)
			logger.error(ex.getMessage());
			return ResponseEntity.notFound().build();
		} catch (BadResourceException ex) {
			// log exception first, then return Bad Request (400)
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Void> deleteRecord(@PathVariable("id") int id) {

		try {
			productService.delete(id);
			return ResponseEntity.ok().build();
		} catch (ResourceNotFoundException ex) {
			logger.error(ex.getMessage());
			return ResponseEntity.notFound().build();
		}
		
//		return userService.findUserById(id)
//				.map(user -> {
//					userService.deleteUserById(id);
//					return ResponseEntity.ok(user);
//				})
//				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}
