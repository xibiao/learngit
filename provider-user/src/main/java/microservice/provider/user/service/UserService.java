package microservice.provider.user.service;

import microservice.provider.user.entity.User;
import microservice.provider.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private UserRepository userRepository;

    public User findUser(Integer id){
        return this.userRepository.getOne(id);
    }

}
