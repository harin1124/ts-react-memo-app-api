package react.memo.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    // 회원가입
    
    // 로그인
    

    @PostMapping("/user")
    public void join(){
        System.out.println("회원가입 시도");
    }
}