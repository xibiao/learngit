package microservice.consumer.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    //Springcloud中ribbon默认使用的是round ribbon，即轮询
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
