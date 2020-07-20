package ap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class B11EurekaServer {

	public static void main(String[] args) {
		SpringApplication.run(B11EurekaServer.class, args);
		System.out.println("####### Eureka Server is Up & Ready @ 8761 #########");
	}

}
