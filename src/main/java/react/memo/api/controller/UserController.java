package react.memo.api.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import react.memo.api.config.auth.PrincipalDetails;
import react.memo.api.dto.Users;
import react.memo.api.repository.UserRepository;
import org.springframework.security.core.Authentication;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * 로그인
	 * @param authentication 로그인 요청 객체
	 * @return ResponseEntity
	 */
	@GetMapping("user")
	public String user(Authentication authentication) {
		PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
		System.out.println("principal : " + principal.getUser().getUserSeq());
		System.out.println("principal : " + principal.getUser().getUserId());
		System.out.println("principal : " + principal.getUser().getPassword());

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