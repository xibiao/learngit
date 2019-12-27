package microservice.consumer.movie;

import microservice.consumer.ribbon.config.TestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "provider-user", configuration = TestConfiguration.class)
public class MovieRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRibbonApplication.class, args);
	}
}
