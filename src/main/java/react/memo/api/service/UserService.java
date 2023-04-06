package react.memo.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import react.memo.api.controller.UserController;
import react.memo.api.dto.User;
import react.memo.api.dto.UserRepository;

@Service
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;
    
    public User getUser(User paramObject){
        User findUser = userRepository.findByUserId(paramObject.getUserId());
        User userInfo = new User();
        if(findUser != null){
            userInfo.setUserId(findUser.getUserId());
            userInfo.setUserSeq(findUser.getUserSeq());
        }
        return userInfo;
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