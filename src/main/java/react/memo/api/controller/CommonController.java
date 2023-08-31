package react.memo.api.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import react.memo.api.dto.Users;
import react.memo.api.repository.UserRepository;

@RestController
@RequiredArgsConstructor
public class CommonController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserRepository userRepository;
    
    /**
     * 아이디 중복 확인
     * @param userId 유저가 사용하려는 아이디
     * @return 중복 여부 (중복 = true, 미중복 = false)
     */
    @GetMapping("/use/{userId}")
    public ResponseEntity<Boolean> useUserIdCheck(@PathVariable String userId){
        Users findUser = userRepository.findByUserId(userId);
        boolean isUse = findUser != null;
        
        return ResponseEntity.ok().headers(new HttpHeaders()).body(isUse);
    }
}