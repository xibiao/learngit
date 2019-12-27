package microservice.consumer.movie.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * ribbon具有负载均衡的功能，@LoadBalanced注解使得RestTemplate具备ribbon负载均衡的能力
     * 电影微服务调用用户微服务时，url不能使用用户微服务的ip:port形式，
     * 必须是在eureka上注册的用户微服务的application的值。
     * 参考：https://blog.csdn.net/awhip9/article/details/70599014
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
