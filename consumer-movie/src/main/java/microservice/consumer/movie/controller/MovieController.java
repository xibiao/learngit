package microservice.consumer.movie.controller;

import microservice.consumer.movie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    //无法注入RestTemplate，参考：https://www.cnblogs.com/EasonJim/p/7546136.html
    @Autowired
    private RestTemplate restTemplate;

    @Value("${consumer.movie.userUrl}")
    private String userUrl;

    @GetMapping(value = "/find/{id}")
    public User findUserById(@PathVariable("id") Integer id){
        //return restTemplate.getForObject("http://localhost:7900/provider/user/find/" + id,User.class);
        System.out.println(userUrl + String.valueOf(id));
        return restTemplate.getForObject(userUrl + String.valueOf(id),User.class);
    }

}
