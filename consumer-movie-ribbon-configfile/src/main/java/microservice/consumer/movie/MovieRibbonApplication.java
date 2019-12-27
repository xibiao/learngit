package microservice.consumer.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRibbonApplication.class, args);
	}
}
