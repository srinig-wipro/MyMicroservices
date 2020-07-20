package ap.sb.domain;

import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Configuration
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {
	private Long id;
	private String name;
	private String brand;
	private String madein;
	private float price;
}
