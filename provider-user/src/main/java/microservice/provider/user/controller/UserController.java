package microservice.provider.user.controller;

import microservice.provider.user.entity.User;
import microservice.provider.user.service.UserService;
import microservice.provider.user.utils.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/find/{id}")
    public User findUser(@PathVariable("id") Integer id){
        System.out.println(port + "============user service is used!============");
        return userService.findUser(id);
    }
    /*public RespResult<User> findUser(@PathVariable("id") Integer id){
        User user = userService.findUser(id);
        //User user = new User();
        //user.setId(id);
        //user.setUsername("111111");
        //user.setName("郁闷");
        return RespResult.ok(user);
    }*/
}
