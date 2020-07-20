package ap.sb.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import ap.sb.domain.Product;



@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Value("${app.product.welcomepage}")
	private String welcomepage;
	
	@Value("${app.product.welcomemessage}")
	private String welcomeMessage;

	@Value("${app.product.listpage}")
	private String listpage;

	@GetMapping("/")
	public ResponseEntity<String> getMessage() {
		return ResponseEntity.ok("Welcome to Product-EndPoints Example");
	}
	
	@GetMapping("/getwelcomepage")
	public ModelAndView getMavWelcomePage() {
		System.out.println("## getwelcomepage is being executed ## "+ welcomepage+" : "+welcomeMessage);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("greeting", welcomeMessage);
		return new ModelAndView(welcomepage, model);
		
	}	
	@GetMapping("/getlistpage")
	public ModelAndView getMavList() {
		System.out.println("List Page is =====: " + listpage);
		Map<String, Object> model = new HashMap<String, Object>();
		List<Product> listProducts = getProductList();
		model.put("viewProducts", listProducts);
		model.put("msg", "Welcome !!!  Product List");
		return new ModelAndView(listpage, model);
	}
	

	private List<Product> getProductList() {
		List<Product> products = new ArrayList<Product>();
		Product p1 = new Product("TV", "sony", "japan", 1987.56f);
		Product p2 = new Product("Cell Phone", "One+", "China", 1434.78f);
		Product p3 = new Product("Air Purifier", "Datasun", "Korea", 1568.3f);
		products.add(p1);
		products.add(p2);
		products.add(p3);
		return products;
	}


}

//@GetMapping("/getindexpage")
//public ModelAndView getMAV() {
//	Map<String, Object> model = new HashMap<String, Object>();
////	List<Product> listProducts = productService.listAllRecords();
////	model.put(getProducts, listProducts);
//	model.put("msg", "Welcome !!!  Product List");
//	return new ModelAndView(listpage, model);
//}
//
//@GetMapping("/read/{id}")
//public ResponseEntity<Product> readProductById(@PathVariable("id") int id) {
//	Product product =null;
//	
//	return ResponseEntity.ok(product);
//}
//
//// Code coverage
//// controller has to integarte with service (service has to execute)
//// MockBean to mock the response and performing unit testing
//
//@GetMapping("/read/all")
//public ResponseEntity<List<Product>> readAllProducts() {
//	List<Product> products=null;
//	return ResponseEntity.ok(products);
//}
//
//@PostMapping("/create")
//public ResponseEntity<Product> createRecord(@Valid @RequestBody Product product) throws URISyntaxException {
//	// return new ResponseEntity<Product>(productService.save(product),
//	// HttpStatus.CREATED);
//
//	Product newProduct = null;
//	return ResponseEntity.created(new URI("/api/product/create" + newProduct.getId())).body(product);
//}
