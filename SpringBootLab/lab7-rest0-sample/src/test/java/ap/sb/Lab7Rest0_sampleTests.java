package ap.sb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ap.sb.controller.ProductController;

@SpringBootTest
class Lab7Rest0_sampleTests {
	@Autowired
	private ProductController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
