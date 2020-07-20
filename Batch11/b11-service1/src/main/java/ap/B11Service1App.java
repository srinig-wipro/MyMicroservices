package ap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
public class B11Service1App {

	public static void main(String[] args) {
		SpringApplication.run(B11Service1App.class, args);
		System.out.println("##### Service 1 is up & ready @ 8090 #####");
	}

}

@RestController
@RefreshScope
class Service1Controller{
	
	@Autowired
	EurekaClient eurekaClient;
	
	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	
	@Value("${message: Hello Default}")
	private String message;

	@Value("${user.role: Default Default}")
	private String role;

	@GetMapping("/")
	public String getMessageDefault() {
		return "Use /message to check Default message .... use /whoami/{username} for role based response";
	}
	@GetMapping("/message")
	public String getMessage() {
		
		return this.message;
	}

	@RequestMapping(
			value = "/whoami/{username}", 
			method = RequestMethod.GET
			)
	public String whoami(@PathVariable("username") String userName) {
		return "Hello you are " + userName + " you are a " + role;
	}
	
	
	@GetMapping("/greet")
	public String greetString() {		
		// clalls service 2 before giving its response
		return "Hello Greeting Controller from Service 1 App #######";
	}
	
	@GetMapping("/getservice2")
	public String invokeService() {
	RestTemplate restTemplate=restTemplateBuilder.build();		
	//Using Eureka server
	InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("service2-app", false); //eureka service logical name
	String baseUrl=instanceInfo.getHomePageUrl();
	baseUrl=baseUrl+"/greet";
	return restTemplate.getForObject(baseUrl, String.class);
	}
}
