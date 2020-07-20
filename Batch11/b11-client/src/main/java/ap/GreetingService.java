package ap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class GreetingService {
	
	@Autowired
	EurekaClient eurekaClient;
	
	@Autowired
	RestTemplateBuilder restTemplateBuilder;
	
	@HystrixCommand(fallbackMethod = "defaultGreeting")
	
//	@HystrixCommand(
//			  commandKey = "ratingsByIdFromDB", 
//			  fallbackMethod = "findCachedRatingById", 
//			  ignoreExceptions = { RatingNotFoundException.class },
//			  commandProperties = {
//			  @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
//			})

//	@HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
//			   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//			})
//	
	public String  getGreeting(String username){		
		
		
		RestTemplate restTemplate=restTemplateBuilder.build();
		InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("service2-app", false);
		String baseUrl=instanceInfo.getHomePageUrl();
		baseUrl=baseUrl+"/greet/"+username;
		System.out.println(baseUrl);
		return restTemplate.getForObject(baseUrl, String.class);
	}
	

	
	public String defaultGreeting(String username) {
		return "Hello this is default greeting (Static Data) When service2 is down !!!==>";
	}

}
