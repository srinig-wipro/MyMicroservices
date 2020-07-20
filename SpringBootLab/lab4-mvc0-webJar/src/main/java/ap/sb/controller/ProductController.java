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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ap.sb.domain.Product;
import lombok.Data;

//required dependecies - web & jasper
//properties config for view resolver => spring.mvc.view.prefix & suffix


@Controller
@RequestMapping("/product")
public class ProductController {

	// inject via application.properties
	@Value("${app.product.message:This is default message}")
	private String message;

	@Value("${app.product.htmlmessage:This is default message}")
	private String htmlMessage;

	@Value("${app.product.welcomepage}")
	private String welcomepage;

	@Value("${app.product.listpage}")
	private String listpage;

	@GetMapping("/")
	public String getMessage() {
		System.out.println("GetMessage() executed and no response displayed on browser due to view resolver couldn't match a file");
		return "Welcome to Product-EndPoints Example";
		// Note: Data will not be displayed ** String identified as view page name
	}

	@GetMapping("/getindex")
	public String welcome(Map<String, Object> model) {
		System.out.println("##welcome() executed###");
		model.put("message", this.message);
		return "welcomepage";
	}

	@RequestMapping(value = "/welcomemvc", method = RequestMethod.GET)
	public ModelAndView getMVC() {
		System.out.println("simple/welcome end point executed");
		return new ModelAndView("mvcpage", "message", htmlMessage);
	}

	@GetMapping("/getobjectpage")
	public ModelAndView getMavObject() {
		Map<String, Object> model = new HashMap<String, Object>();
		Product product = new Product("TV", "sony", "japan", 1987.56f);
		model.put("viewProduct", product);
		model.put("msg", "Welcome !!!  FInd Product Details ");
		return new ModelAndView("objectpage", model);
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

	@RequestMapping(value = "/getsimpleform", method = RequestMethod.GET)
	public ModelAndView getForm() {
		String message = "<br><div align='center'>" + "<h1>This requested page <h1> <br>";
		message += "<a href='simpleform'>Return to Welcome Page</a>";
		return new ModelAndView("getform", "message", message);
	}

	@RequestMapping(value = "/process", method = RequestMethod.POST)	
	public ModelAndView processForm(@ModelAttribute("product") Product product) {
		Map<String, Object> model = new HashMap<String, Object>();
		product.setId(1224);
		model.put("viewProduct", product);
		model.put("msg", "Welcome !!!  FInd Product Details ");
		return new ModelAndView("objectpage", "viewProduct", product);
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
