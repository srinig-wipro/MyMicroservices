package ap.sb.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ap.sb.domain.Product;
import ap.sb.service.ProductService;
import ap.sb.util.CustomErrorType;

@RestController
@RequestMapping("/product-mgmt")
public class ProductController {

	public static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;

	@GetMapping("/")
	public ResponseEntity<String> a1GetMessage() {
		logger.info("use\n" + "1. Post request (Create Record)		: /product-mgmt/\n"
				+ "2. Get request (Read record By ID) 	: /read/{id}\n"
				+ "3. Get request (Read All records)	: /read/all\n"
				+ "4. PUT request (Update record by ID)	: /{id}\n"
				+ "5. DELETE request (Delete by ID)		: /product/{id}\n"
				+ "6. DELET ALL Records					: /product/\n");
		
		String response="1. Post request (Create Record)		: /product-mgmt/<br>"
				+ "2. Get request (Read record By ID) 	: /read/{id}<br>"
				+ "3. Get request (Read All records)	: /read/all<br>"
				+ "4. PUT request (Update record by ID)	: /{id}<br>"
				+ "5. DELETE request (Delete by ID)		: /product/{id}<br>"
				+ "6. DELET ALL Records					: /product/";

		return new ResponseEntity<String>(response, HttpStatus.OK);
		// ResponseEntity.ok(productService.getMessage());
	}

	// ---------Create a Product---------------------
		@PostMapping
		public ResponseEntity<?> a2Create(@Valid @RequestBody Product product) {
			logger.info("Creating Product : {}", product);
			ResponseEntity<?> response = new ResponseEntity<>(
					new CustomErrorType("Unable to create. A Product with name " + product.getName() + " already exist."),
					HttpStatus.CONFLICT);
			if (!productService.isProductExist(product)) {
				Product savedProduct = productService.saveProduct(product);
				response = new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
			}
			return response;
		}

		// ------ Retrieve Single Product----------------------
		@GetMapping("/read/{id}")
		public ResponseEntity<?> a3ReadById(@PathVariable int id) {
			logger.info("Fetching Product with id {}", id);
			ResponseEntity<?> response = new ResponseEntity<>(new CustomErrorType("Product with id " + id + " not found"),
					HttpStatus.NOT_FOUND);

			Product foundProduct = productService.findById(id);

			if (foundProduct != null) {
				response = ResponseEntity.ok(foundProduct);
			}
			return response;
		}

		// -----------Retrieve All Products----------------------

		@GetMapping("/read/all")
		public ResponseEntity<?> a4ReadAllProducts() {
			logger.info("Fetching All Product ");
			ResponseEntity<?> response = new ResponseEntity<>(new CustomErrorType("Products are not found"),
					HttpStatus.NOT_FOUND);
			List<Product> products = productService.findAllProducts();
			if (!products.isEmpty()) {
				response = ResponseEntity.ok(products);
			}
			return response;
		}

		// ------------ Update a Product ----------------------
		@PutMapping("/{id}")
		public ResponseEntity<?> a5Update(@PathVariable int id, @Valid @RequestBody Product product)
				throws IllegalAccessException, InstantiationException {
			logger.info("Updating Product with id {}", id);
			ResponseEntity<?> response = new ResponseEntity<>(
					new CustomErrorType("Unable to upate. Product with id " + id + " not found."), HttpStatus.NOT_FOUND);

			Product foundProduct = productService.findById(id);
			if (foundProduct != null) {
				// Product revisedProduct = mergeObjects(product,foundProduct);
				product.setId(id);
				productService.updateProduct(product);
				response = ResponseEntity.ok(product);
			}
			return response;
		}

		// ------------------- Delete a Product-------------------------------
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<?> a6DeleteProduct(@PathVariable("id") int id) {
			logger.info("Fetching & Deleting Product with id {}", id);

			ResponseEntity<?> response = new ResponseEntity<>(
					new CustomErrorType("Unable to delete. Product with id " + id + " not found."), HttpStatus.NOT_FOUND);
			Product foundProduct = productService.findById(id);
			if (foundProduct != null) {
				productService.deleteProductById(id);
				response = new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
			return response;
		}

		// ------------------- Delete All Products-----------------------
		@DeleteMapping("/delete/all")
		public ResponseEntity<Void> a7DeleteAllProducts() {
			logger.info("Deleting All Products");
			productService.deleteAllProducts();
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}

		@SuppressWarnings("unchecked")
		private static <T> T mergeObjects(T first, T second) throws IllegalAccessException, InstantiationException {
			Class<?> clazz = first.getClass();
			java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
			Object returnValue = clazz.newInstance();
			for (java.lang.reflect.Field field : fields) {
				field.setAccessible(true);
				Object value1 = field.get(first);
				Object value2 = field.get(second);
				Object value = (value1 != null) ? value1 : value2;
				field.set(returnValue, value);
			}
			return (T) returnValue;
		}
	}

//private List<Product> getProductList() {
//List<Product> products = new ArrayList<Product>();
//Product p1 = new Product("TV", "sony", "japan", 1987.56f);
//Product p2 = new Product("Cell Phone", "One+", "China", 1434.78f);
//Product p3 = new Product("Air Purifier", "Datasun", "Korea", 1568.3f);
//products.add(p1);
//products.add(p2);
//products.add(p3);
//return products;
//}
//
//private Optional<Product> getProduct() {
//Product p = new Product("TV", "sony", "japan", 1987.56f);
//Optional<Product> optionalProduct = Optional.of(p);
//return optionalProduct;
//}
