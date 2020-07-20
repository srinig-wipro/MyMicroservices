package ap.sb.controller.it;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ap.sb.domain.Product;



/* TestRestTemplate -> creates a Rest Client for us Request building. */
//To mark Trasaction Boundaries, instead of relying on @Trasactional you may use @BeforeAll, @AfterAll.
//Preferences > Java > Editor > Content Assist > Favorites..add new types to get static imports
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.hamcrest.Matchers.*;
//import static org.mockito.BDDMockito.*;
//Preferences > Java > Editor > Content Assist > Favorites..add new types to get static imports

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTestIT {

	private static Product p1;
    private static Product p2;
    private static Product p3;
    private static Product p4;
    private static Product p5;
    private static String URI;

    @LocalServerPort
    private static int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeAll
    public static void init() {
		 p1 = new Product("TV", "sony", "japan", 1987.56f);
		 p2 = new Product("Cell Phone", "One+", "China", 1434.78f);
		 p3 = new Product("Air Purifier", "Datasun", "Korea", 1568.3f);
		 p4 = new Product("TV2", "sony", "japan", 1987.56f);
		 p5 = new Product("Cell2", "One+", "China", 1434.78f);	
		 URI="http://127.0.0.1:"+port+"/products/";
    }

    @Test
    public void findAllTestIT() {

        ResponseEntity<Product[]> result= this.restTemplate
                .getForEntity(URI, Product[].class);

        assertThat(result.getStatusCode(), equalTo(HttpStatus.OK));

        assertThat(result.getBody(), is(notNullValue()));
    }

    @Test
    public void createTestIT() {

        HttpEntity<Product> request = new HttpEntity<>(p1);
        ResponseEntity<Product> response = restTemplate.postForEntity(URI, request, Product.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
        assertThat(response.getBody().getName(), is("TV"));
        restTemplate.delete(URI+response.getBody().getId());
    }

    @Test
    public void updateTestIT() {

        HttpEntity<Product> request = new HttpEntity<>(p2);
        ResponseEntity<Product> response = restTemplate.postForEntity(URI, request, Product.class);

        long id = response.getBody().getId();

        request = new HttpEntity<Product>(p3);
        response = restTemplate.exchange(URI+id, HttpMethod.PUT, request, Product.class);

        assertThat(response.getBody().getName(), is("P3"));
        assertThat(response.getBody().getId(), is(id));
        restTemplate.delete(URI+id);
    }

    @Test
    public void findByIDTestIT() {

        HttpEntity<Product> request = new HttpEntity<>(p4);
        ResponseEntity<Product> response = restTemplate.postForEntity(URI, request, Product.class);

        long id = response.getBody().getId();

        response = restTemplate.getForEntity(URI+id, Product.class);

        assertThat(response.getBody().getId(), is(id));
        assertThat(response.getBody().getMadein(), equalTo(p4.getMadein()));
        restTemplate.delete(URI+id);
    }

    @Test
    public void deleteByIDTestIT() {

        HttpEntity<Product> request = new HttpEntity<>(p5);
        ResponseEntity<Product> response = restTemplate.postForEntity(URI, request, Product.class);

        long id = response.getBody().getId();

        restTemplate.delete(URI+id);
        response = restTemplate.getForEntity(URI+id, Product.class);

        assertThat(response.getBody(), is(nullValue()));

    }
}
