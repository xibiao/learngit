package microservice.consumer.movie.service;

import microservice.consumer.movie.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "provider-user",fallback = HystrixClientFallback.class)
//@RequestMapping(value = "/provider/user")
public interface UserFeignClient {

    /**
     * 使用feign需要注意的坑：
     * 1、如果参数上不加上@PathVariable注解，会报如下错误：
     * java.net.URISyntaxException: Illegal character in path at index 27: http://consumer-movie/find/{id}
     * 2、feign接口方法上使用mapping注解时，必须写上服务提供者的方法全路径，否则会报如下错误：
     * feign.FeignException: status 404 reading UserFeignClient#findUser(Integer)
     * 比如此处服务提供者provider-user服务的context-path的值是provider，UserController类上有@@RequestMapping(value = "/user")，
     * UserController类中被请求的方法findUser上使用了@GetMapping(value = "/find/{id}")注解，所以这里的UserFeignClient接口中的
     * findUser方法上就要使用@GetMapping(value = "/provider/user/find/{id}")注解，或者将@RequestMapping(value = "/provider/user")
     * 注解用在UserFeignClient接口上，findUser上只需使用@GetMapping(value = "/find/{id}")注解
     * 3、@GetMapping注解可能不起作用，而是使用@RequestMapping(value="",method=RequestMethod.GET)，@PostMapping与此类似
     * 4、若使用断路器hystrix，在接口上就不能使用@RequestMapping，否则同一个请求路径被接口方法和实现类方法同时映射。
     * @param id
     * @return
     */
    @GetMapping(value = "/provider/user/find/{id}")
    User findUser(@PathVariable("id") Integer id);
}
