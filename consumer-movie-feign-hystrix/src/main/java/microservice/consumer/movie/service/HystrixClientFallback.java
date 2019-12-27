package microservice.consumer.movie.service;

import microservice.consumer.movie.entity.User;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements UserFeignClient {
    @Override
    public User findUser(Integer id) {
        User user = new User();
        user.setId(0);
        user.setUsername("feign with hystrix");
        return user;
    }
}
