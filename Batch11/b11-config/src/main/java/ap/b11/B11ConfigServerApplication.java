package ap.b11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class B11ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(B11ConfigServerApplication.class, args);
	}

}
