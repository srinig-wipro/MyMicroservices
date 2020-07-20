package ap.sb.controller.it;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import ap.sb.domain.Product;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
class ProductControllerTestUisingMockIT {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	public void a1GetMessage() throws Exception {
		this.mockMvc.perform(get("/product-mgmt/"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().string(containsString("Welcome to REST API World !!!!")));
		
		mockMvc
	    .perform(get("/product-mgmt/")
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())   //HTTP response is 200
        .andExpect(MockMvcResultMatchers.jsonPath("$").value("Welcome to REST API World !!!!"));
	}
	
	@Test
	@Order(2)
	public void a2CreateRecord() throws Exception {
		Product product1 = new Product("TV", "sony", "japan", 1987.56f);
		Product product2 = new Product("Cell Phone", "One+", "China", 1434.78f);
		
		mockMvc.perform(post("/product-mgmt/")				
				.content(asJsonString(product1))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
		
		mockMvc.perform(post("/product-mgmt/")				
				.content(asJsonString(product2))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2));		
	}

	
	@Test
	@Order(3)
	void a3GetObjectFindByID() throws Exception {
		mockMvc
	    .perform(get("/product-mgmt/read/1")
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())  
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("TV"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.brand").value("sony"));		
	}
	
	@Test
	@Order(4)
	public void a4ReadRecordWhenNotPresent() throws Exception {
		mockMvc
		    .perform(get("/product-mgmt/read/4")
		    .contentType(MediaType.APPLICATION_JSON)
		    .accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().isNotFound())  ;
	       
	}

	@Test
	@Order(5)
	void a5GetListReadAll() throws Exception {
	
		mockMvc
	    .perform(get("/product-mgmt/read/all")
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())   
        .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
		.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
	    .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("TV"))
	    .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Cell Phone"));	    
	}

	@Test
	@Order(6)
	public void a6UpdateRecord() throws Exception {
		Product product = new Product("TV", "sony", "japan_revised", 1987.56f);
		mockMvc.perform(put("/product-mgmt/1")
				.content(asJsonString(product))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.madein").value("japan_revised"));
	}

	@Test
	@Order(7)
	public void a7DeleteRecord() throws Exception {
		
		mockMvc.perform(delete("/product-mgmt/delete/2"))
		.andExpect(status().isAccepted());
	}
	
	@Test
	@Order(8)
	public void a8DeleteAllRecords() throws Exception {
		mockMvc.perform(delete("/product-mgmt/delete/all"))
		.andExpect(status().isAccepted());
	}
	
	@Test
	@Order(9)
	void a9GetListReadAllWhenEmpty() throws Exception {
	
		mockMvc
	    .perform(get("/product-mgmt/read/all")
	    .contentType(MediaType.APPLICATION_JSON)
	    .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound()) ;	    
	}
	
	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
