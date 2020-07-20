package ap.sb.dto;

import java.io.Serializable;

import org.springframework.context.annotation.Configuration;

import ap.sb.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Configuration
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class DemoDTO implements Serializable{
	String productName;
	int availableQuanity;
	String storeName;
}
