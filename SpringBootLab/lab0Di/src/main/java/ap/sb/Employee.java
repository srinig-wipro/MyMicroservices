package ap.sb;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Configuration
@Data  //= getters & setters for all members
@RequiredArgsConstructor  // deafult, all args constructor, over loaded constructeor
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
