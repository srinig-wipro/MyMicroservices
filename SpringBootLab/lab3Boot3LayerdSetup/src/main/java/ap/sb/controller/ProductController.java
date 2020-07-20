package ap.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ap.sb.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;

	public String getProductController() {
		System.out.println(productService.getProductService());
		return ".. Product Controller is executed ...";
	}
}
