package ap.sb;

import java.util.Arrays;

import javax.sql.DataSource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Lab1Env {
	
	@Value("${lab1.message}")
	private String message;
	
	@Value("${lab1.display: defined value}")
	private String value1;
	
	@Value("${lab1.defaultvalue:default Message}")
	private String defaultValue;
	

	@Autowired
	private Environment env;
	
	@Autowired
	private DataSource dataSource;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(Lab1Env.class, args);
		System.out.println(" ######### Lab 1 App Executed ##############");
	}	
	
	@Bean
	CommandLineRunner runDemo(Employee emp,ApplicationContext ctx) {
		return(args)->{
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
			System.out.println("+++++++++++++++++++++++++++");
			
			
			System.out.println(message);
			System.out.println(value1);
			System.out.println(defaultValue);			
			System.out.println(emp);			
			System.out.println("+++++++++++++++++++++++++++");
			
			System.out.println(env);
			System.out.println(env.getProperty("JAVA_HOME"));
			System.out.println(env.getProperty("spring.application.name"));
			
			System.out.println(env.getProperty("lab1.message"));			
			System.out.println(dataSource.getConnection());
						
			System.out.println("####### Logger ########");
			logger.trace("A TRACE Message");
	        logger.debug("A DEBUG Message");
	        logger.info("An INFO Message");
	        logger.warn("A WARN Message");
	        logger.error("An ERROR Message");
	        System.out.println("Hey!!! Check out the Logs to see the output...");
	};
	


	}

}
