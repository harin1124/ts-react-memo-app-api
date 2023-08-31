package react.memo.api.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import react.memo.api.config.auth.PrincipalDetails;
import react.memo.api.user.dto.Users;
import react.memo.api.user.repository.UserRepository;

import java.util.HashMap;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    
    /**
     * 로그인
     * @param authentication 로그인 요청 객체
     * @return ResponseEntity
     */
    @GetMapping("user")
    public String user(Authentication authentication) {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        log.debug("principal : " + principal.getUser().getUserId());
        log.debug("principal : " + principal.getUser().getPassword());
        log.debug("principal : " + principal.getUser().getUserSeq());
        
        return "<h1>user</h1>";
    }
    
    /**
     * 회원가입
     * @param user 회원가입을 시도한 유저 객체
     * @return 성공 여부
     */
    @PostMapping("/join")
    @ResponseBody
    public HashMap<String, Object> userJoin(@RequestBody Users user){
        HashMap<String, Object> resultMap = new HashMap<>();
        
        // validation - password
        if(user.getPassword() == null || "".equals(user.getPassword())){
            resultMap.put("stat", "error");
            return resultMap;
        }
        
        // 회원가입 진행
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUserRole("ROLE_USER");
        userRepository.save(user);
        resultMap.put("stat", "success");
        return resultMap;
    }
}