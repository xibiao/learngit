package microservice.consumer.movie.controller;

import microservice.consumer.movie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${consumer.movie.userUrl}")
    private String userUrl;

    @Value("${consumer.movie.userRibbonUrl}")
    private String userRibbonUrl;

    @GetMapping(value = "/find/{id}")
    public User findUserById(@PathVariable("id") Integer id){
        //return restTemplate.getForObject("http://localhost:7900/provider/user/find/" + id,User.class);
        System.out.println(userUrl + String.valueOf(id));
        return restTemplate.getForObject(userUrl + String.valueOf(id),User.class);
    }

    @GetMapping(value = "/ribbon/find/{id}")
    public User findUser(@PathVariable("id") Integer id){
        //return restTemplate.getForObject("http://localhost:7900/provider/user/find/" + id,User.class);
        System.out.println(userRibbonUrl + String.valueOf(id));
        return restTemplate.getForObject(userRibbonUrl + String.valueOf(id),User.class);
    }

    @GetMapping(value = "/ribbon/config")
    public String findUserWithConfigFile(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("provider-user");
        System.out.println("111111:"+serviceInstance.getServiceId()+":"+serviceInstance.getHost()+":"+serviceInstance.getPort());

        ServiceInstance instance = this.loadBalancerClient.choose("provider-user-two");
        System.out.println("222222:"+instance.getServiceId()+":"+instance.getHost()+":"+instance.getPort());

        return "success!";
    }

}
