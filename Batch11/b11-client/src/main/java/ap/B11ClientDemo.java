package ap;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class B11ClientDemo {

	public static void main(String[] args) {
		SpringApplication.run(B11ClientDemo.class, args);
		System.out.println("####### Eureka Client Demo is up & ready @ 8888 ########");
	}

}

@RestController
class DemoClient{
	
	@Autowired
	EurekaClient eurekaClient;
	
	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
//	@Autowired
//	RestTemplate restTemplateLoadBalanced;
	
	@Autowired
	GreetingService greetingService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	
	
	
//	@GetMapping("/")
//	public String getWelcome() {
//	RestTemplate restTemplate=restTemplateBuilder.build();		
//	
//	return "<h2><b> Use /greetfromeureka1 or  /greetfromeureka1 to demonstarte service discoverability<br> "
//			+ "use /getservicethroughzuul1 or  /getservicethroughzuul2 to demonstarte service discoverability (from service1/service2) throug gateway</b></h2>";
//	}
//	
//	@GetMapping("/greetfromeureka1")
//	public String invokeService() {
//	RestTemplate restTemplate=restTemplateBuilder.build();		
//	//Using Eureka server
//	InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("service1-app", false); //eureka service logical name
//	String baseUrl=instanceInfo.getHomePageUrl();
//	baseUrl=baseUrl+"/greet";
//	return restTemplate.getForObject(baseUrl, String.class);
//	}
//	
//	@GetMapping("/greetfromeureka2")
//	public String invokeService2() {
//	RestTemplate restTemplate=restTemplateBuilder.build();		
//	//Using Eureka server
//	InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("service2-app", false); //eureka service logical name
//	String baseUrl=instanceInfo.getHomePageUrl();
//	baseUrl=baseUrl+"/greet";
//	return restTemplate.getForObject(baseUrl, String.class);
//	}
//	
//	@GetMapping("/getservicethroughzuul1")
//	public String invokeService3() {
//	RestTemplate restTemplate=restTemplateBuilder.build();		
//	//Using Zuul proxy
//	InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("zuul-gateway", false); //eureka service logical name
//	String baseUrl=instanceInfo.getHomePageUrl();
//	baseUrl=baseUrl+"/api/service1app/greet";
//	System.out.println(baseUrl+" ##########################");
//	return restTemplate.getForObject(baseUrl, String.class);
//	}
//	
//	@GetMapping("/getservicethroughzuul2")
//	public String invokeService4() {
//	RestTemplate restTemplate=restTemplateBuilder.build();		
//	//Using Zuul proxy
//	InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("zuul-gateway", false); //eureka service logical name
//	String baseUrl=instanceInfo.getHomePageUrl();
//	baseUrl=baseUrl+"/api/service2app/greet";
//	System.out.println(baseUrl+" ##########################");
//	return restTemplate.getForObject(baseUrl, String.class);
//	}
//	
//	
	
	
	
	
	@GetMapping("/whatsup")
	public String demoRibbon(@RequestParam(value="activity",defaultValue="Learning")String activity) throws InterruptedException {
		
		//TimeUnit.SECONDS.sleep(5);

		String subject=this.restTemplate.getForObject("http://service2-app/ribbonmessage", String.class);
		return String.format("%s %s", activity,subject);
	}
	
	
	
	
	
	
	
	@GetMapping("/hystrixgreeting/{username}")
	public ModelAndView greetString( @PathVariable("username") String username) {
		
		Map<String, Object> model = new HashMap<String, Object>();		
		String response=greetingService.getGreeting(username);		
		
		model.put("greeting", response);
								//System.out.println(model.toString()+"  ###########");
								//model.put("greeting", "testinghhhh");
								//model.put("number", "23445");
		return new ModelAndView("myview", model);
	}
	
	
}
