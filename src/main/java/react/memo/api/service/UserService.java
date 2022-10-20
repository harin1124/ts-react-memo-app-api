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
        User returnUser = User.builder().userId(findUser.getUserId()).build();
        return returnUser;
    }

    public String userJoin(User paramObject){
        boolean isUseUserId = isUseUserId(paramObject);
        if(!isUseUserId){
            return "error:userId duplication";
        }

        userRepository.saveAndFlush(paramObject);
        return "success";
    }

    public boolean isUseUserId(User paramObject){
        User findUser = userRepository.findByUserId(paramObject.getUserId());
        if(findUser == null || "".equals(findUser.getUserId())){
            return true;
        }
        return false;
    }
}