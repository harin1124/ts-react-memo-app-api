package react.memo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import react.memo.api.dto.User;
import react.memo.api.dto.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public User getUser(User paramObject){
        User findUser = userRepository.findByUserId(paramObject.getUserId());
        System.out.println("findUser : "+findUser);
        return null;
    }

    public void userJoin(User paramObject){
        System.out.println("서비스 들어옴");
    }
}
