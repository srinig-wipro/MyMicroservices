package ap;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class B11Service2App {

	public static void main(String[] args) {
		SpringApplication.run(B11Service2App.class, args);
		System.out.println("##### Service 1 is up & ready @ 8090 #####");
	}

}

@RestController
@RefreshScope
class Service1Controller{
	
	@Value("${server.port}")
	private String serverPort;
	
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
	
	@GetMapping("/greet")
	public String greetString() {
		return "Hello Greeting Controller from Service 2 App !!!!!!";
	}

	@RequestMapping(
			value = "/whoami/{username}", 
			method = RequestMethod.GET
			)
	public String whoami(@PathVariable("username") String userName) {
		return "Hello you are " + userName + " you are a " + role;
	}
	
	
	@RequestMapping("/ribbonmessage")
	public String serverResponse() {
		List<String> messages=Arrays.asList("Architect & Design","Foundation","Implementation","Containerization","Orchestartion");
		Random random=new Random();
		int randomNum=random.nextInt(messages.size());
		return messages.get(randomNum)+" - @ port# "+serverPort;
	}
	
	
	@RequestMapping("/greet/{username}")
	public String greetString(@PathVariable("username") String username) {
		return String.format("Hello %s!",username);
	}
}
