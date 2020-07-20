package ap.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class Lab4Mvc1_boot extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Lab4Mvc1_boot.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(Lab4Mvc1_boot.class, args);
		System.out.println("###### Up & Ready #####");
	}

}
