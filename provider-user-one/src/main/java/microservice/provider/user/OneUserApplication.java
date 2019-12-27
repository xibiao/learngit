package microservice.provider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OneUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneUserApplication.class, args);
	}
}
