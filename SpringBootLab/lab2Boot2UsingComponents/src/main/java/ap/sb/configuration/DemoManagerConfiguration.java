package ap.sb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class DemoManagerConfiguration {
   
	@Bean(name="managerService")
    public DemoManager managerService() {
		return new DemoManagerImpl();        
    }
	
}
