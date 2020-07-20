package ap.sb;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Configuration
@Data
@RequiredArgsConstructor 
public class Employee implements Serializable{
	
	@Value("${lab1.employee.name}")
	String name;
	
	@Value("${lab1.employee.email}")
	String email;
	
	@Value("${lab1.employee.strengths}")
	List<String> strengths;
	
	@Value("#{${lab1.employee.valuesMap}}")
	Map<String, Long> contacts;



}
