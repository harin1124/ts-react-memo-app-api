package react.memo.api.service;

import org.springframework.stereotype.Service;

import react.memo.api.dto.User;

@Service
public class UserService {
    
    public void userJoin(User paramObject){
        System.out.println("서비스 들어옴");
    }
}
