package patel.msf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

@RestController
public class AppController {

	@Autowired
	private ProductService service; 
	
	@Value("${app.indexpage}")
	private String indexPage;
	
	@Value("${app.getproducts}")
	private String getProducts;
	
	@GetMapping("/")
	public ModelAndView viewHomePage() {
		Map<String, Object> model = new HashMap<String, Object>();
		
		List<Product> listProducts = service.listAll();
		model.put(getProducts, listProducts);	
		model.put("msg", "Welcome !!!  Product List");		
		return new ModelAndView(indexPage,model);
	}
	
	@GetMapping("/new")
	public ModelAndView showNewProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);		
		return new ModelAndView("new_product");
	}
	
	@PostMapping("/save")
	public ModelAndView saveOrUpdateProduct(@ModelAttribute Product product) {
		System.out.println("************************");
		service.save(product);		
		return new ModelAndView("redirect:/");
	}	
	
	
	@GetMapping(value ="/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable("id") int id) {
		Map<String, Object> model = new HashMap<String, Object>();
		Product product = service.get(id);
		model.put("product", product);		
		return new ModelAndView("edit_product",model);
	}
	
//	@PostMapping(value ="/update")
//	public ModelAndView updateProduct(@ModelAttribute Product product) {
//System.out.println("Update ##########");
//		//Map<String, Object> model = new HashMap<String, Object>();
//		service.save(product);
//		
//	
//		return new ModelAndView("redirect:/");
//	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return new ModelAndView("redirect:/");		
	}
}
