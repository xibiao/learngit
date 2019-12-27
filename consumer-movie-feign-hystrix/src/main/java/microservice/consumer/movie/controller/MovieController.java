package microservice.consumer.movie.controller;

import microservice.consumer.movie.entity.User;
import microservice.consumer.movie.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping(value = "/find/{id}")
    public User findUserById(@PathVariable("id") Integer id){
        User user = this.userFeignClient.findUser(id);
        System.out.println(id + "==================="+user.getId());
        return user;
    }

}
