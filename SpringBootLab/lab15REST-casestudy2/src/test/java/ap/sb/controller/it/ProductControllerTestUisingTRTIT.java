package ap.sb.controller.it;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ap.sb.domain.Product;

/* TestRestTemplate -> creates a Rest Client for us Request building. */
//To mark Trasaction Boundaries, instead of relying on @Trasactional you may use @BeforeAll, @AfterAll.
//Preferences > Java > Editor > Content Assist > Favorites..add new types to get static imports
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.hamcrest.Matchers.*;
//import static org.mockito.BDDMockito.*;
//Preferences > Java > Editor > Content Assist > Favorites..add new types to get static imports

//@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTestUisingTRTIT {

	private static Product p1;
	private static Product p2;
	private static Product p3;
	private static Product p4;
	private static Product p5;
	private String URI;

	@LocalServerPort
	private int randomServerPort;

	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeAll
	public static void init() {

		p1 = new Product("TV", "sony", "japan", 1987.56f);
		p2 = new Product("Cell Phone", "One+", "China", 1434.78f);
		p3 = new Product("Air Purifier", "Datasun", "Korea", 1568.3f);
		p4 = new Product("TV2", "sony", "japan", 1987.56f);
		p5 = new Product("Cell2", "One+", "China", 1434.78f);

	}

	@Test
	public void a1GetMessageIT() {

		URI = "http://localhost:" + randomServerPort + "/product-mgmt/";

		assertThat(this.restTemplate.getForObject(URI + "/", String.class)).contains("Welcome to REST API World !!!!");

		ResponseEntity<String> response =this.restTemplate.getForEntity(URI, String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat(response.getBody(), is("Welcome to REST API World !!!!"));

	}

    @Test
    public void a2CreateTestIT() {
    	URI = "http://localhost:" + randomServerPort + "/product-mgmt/";
        HttpEntity<Product> request = new HttpEntity<>(p1);
        ResponseEntity<Product> response = restTemplate.postForEntity(URI, request, Product.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
        assertThat(response.getBody().getName(), is("TV"));
        restTemplate.delete(URI+response.getBody().getId());
    }
    
    @Test
    public void a3FindByIDTestIT() {
    	URI = "http://localhost:" + randomServerPort + "/product-mgmt/";
        HttpEntity<Product> request = new HttpEntity<>(p4);
        ResponseEntity<Product> savedResponse = restTemplate.postForEntity(URI, request, Product.class);
        int id = savedResponse.getBody().getId();

        ResponseEntity<Product> findByIdResponse = restTemplate.getForEntity(URI+"read/"+id, Product.class);
        assertThat(findByIdResponse.getBody().getId(), is(id));
        assertThat(findByIdResponse.getBody().getMadein(), equalTo(p4.getMadein()));
        restTemplate.delete(URI+"delete/"+id);
    }
    
    @Test
    public void a4FindAllTestIT() {
    	URI = "http://localhost:" + randomServerPort + "/product-mgmt/read/all";
        ResponseEntity<Product[]> result= this.restTemplate.getForEntity(URI, Product[].class);

        assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(result.getBody(), is(notNullValue()));
    }

    @Test
    public void a5UpdateTestIT() {
    	URI = "http://localhost:" + randomServerPort + "/product-mgmt/";
        HttpEntity<Product> request = new HttpEntity<>(p2);
        ResponseEntity<Product> response = restTemplate.postForEntity(URI, request, Product.class);

        int id = response.getBody().getId();

        request = new HttpEntity<Product>(p3);
        response = restTemplate.exchange(URI+id, HttpMethod.PUT, request, Product.class);

        assertThat(response.getBody().getName(), is("Cell Phone"));
        assertThat(response.getBody().getId(), is(id));
        restTemplate.delete(URI+"delete/"+id);
    }



    @Test
    public void a6DeleteByIDTestIT() {
    	URI = "http://localhost:" + randomServerPort + "/product-mgmt/";
        HttpEntity<Product> request = new HttpEntity<>(p5);
        ResponseEntity<Product> response = restTemplate.postForEntity(URI, request, Product.class);

        int id = response.getBody().getId();

        restTemplate.delete(URI+"delete/"+id);
        ResponseEntity<?> deleteResponse = restTemplate.getForEntity(URI+"read/"+id, Void.class);
        assertThat(deleteResponse.getBody(), is(nullValue()));
    }
    
    @Test
    public void a7DeleteAllTestIT() {
    	URI = "http://localhost:" + randomServerPort + "/product-mgmt/";
        HttpEntity<Product> request1 = new HttpEntity<>(p5);
        HttpEntity<Product> request2 = new HttpEntity<>(p4);
        ResponseEntity<Product> responseA = restTemplate.postForEntity(URI, request1, Product.class);
        ResponseEntity<Product> responseB = restTemplate.postForEntity(URI, request2, Product.class);

        ResponseEntity<Void> deleteResponse=restTemplate.getForEntity(URI+"delete/all",Void.class);
        assertThat(deleteResponse.getBody(), is(nullValue()));

    }
}
