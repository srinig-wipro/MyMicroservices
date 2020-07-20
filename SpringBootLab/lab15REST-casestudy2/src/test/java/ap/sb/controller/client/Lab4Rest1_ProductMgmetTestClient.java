package ap.sb.controller.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import ap.sb.controller.ProductController;
import ap.sb.domain.Product;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

public class Lab4Rest1_ProductMgmetTestClient {

	public static final String REST_SERVICE_URI = "http://localhost:7878/product-mgmt";

	/* GET */
	private static void a1GetMessage() {
		System.out.println("Testing getMessage API----------");
		String message = new RestTemplate().getForObject(REST_SERVICE_URI + "/", String.class);
		System.out.println(message);
	}

	/* POST */
	private static void a2CreateProduct() {
		System.out.println("Testing create Product API----------");
		Product product = new Product("TVxtdd6", "sony", "japan", 1987.56f);

		ResponseEntity<Object> result = new RestTemplate().postForEntity(REST_SERVICE_URI + "/", product, Object.class);
		// URI uri = new RestTemplate().postForLocation(REST_SERVICE_URI + "/", product,
		// Product.class);
		// System.out.println(uri+" ************8");
		// System.out.println("Location : " + uri.toASCIIString());
		System.out.println(result.getBody());
	}

	/* GET */
	private static void a3GetProduct() {
		System.out.println("Testing getProduct API----------");
		Product product = new RestTemplate().getForObject(REST_SERVICE_URI + "/read/1", Product.class);
		System.out.println(product);
	}

	/* GET */
	@SuppressWarnings("unchecked")
	private static void a4ListAllProducts() {
		System.out.println("Testing listAllProducts API-----------");

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> productsMap = restTemplate.getForObject(REST_SERVICE_URI + "/read/all",
				List.class);

		if (productsMap != null) {
			for (LinkedHashMap<String, Object> map : productsMap) {
				System.out.println("Product : id=" + map.get("id") + ", Name=" + map.get("name") + ", Brand="
						+ map.get("brand") + ", Madein=" + map.get("madein") + ", Price=" + map.get("price"));
			}
		} else {
			System.out.println("No product exist----------");
		}
	}

	/* PUT */
	private static void a5UpdateProduct() {
		System.out.println("Testing update Product API----------");

		Product product = new Product("TV", "sony", "japan", 1987.56f);
		new RestTemplate().put(REST_SERVICE_URI + "/1", product);
		System.out.println(product);
	}

	/* DELETE */
	private static void a6DeleteProduct() {
		System.out.println("Testing delete Product API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/delete/1");
	}

	/* DELETE */
	private static void a7DeleteAllProducts() {
		System.out.println("Testing all delete Products API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/delete/all");
	}

	public static void main(String args[]) {
		a1GetMessage();
		try {
			a2CreateProduct();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			a3GetProduct();

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			a4ListAllProducts();

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			a5UpdateProduct();

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			a4ListAllProducts();

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			a6DeleteProduct();

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			a4ListAllProducts();

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			a7DeleteAllProducts();

		} catch (Exception e) {
			System.out.println(e);
		}

		try {

			a4ListAllProducts();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}