package react.memo.api.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import react.memo.api.dto.User;
import react.memo.api.service.UserService;

@RestController
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/**
	 * 로그인
	 * @param paramUser 로그인 요청 객체
	 * @return ResponseEntity
	 */
	@PostMapping("/user/login")
	@ResponseBody
	public ResponseEntity<User> userLogin(@RequestBody User paramUser){
		User userInfo = userService.getUser(paramUser);

		HttpHeaders resHeaders = new HttpHeaders();
		return new ResponseEntity<User>(userInfo, resHeaders, HttpStatus.OK);
	}

	// 유저 정보 가져오기
	@GetMapping("/user/{userId}")
	public HashMap<String, Object> getUser(@PathVariable String userId){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		User paramUser = User.builder().userId(userId).build();
		User userInfo = userService.getUser(paramUser);
		resultMap.put("userId", userInfo.getUserId());
		return resultMap;
	}

	// 회원가입
	@PostMapping("/user")
	@ResponseBody
	public HashMap<String, Object> userJoin(@RequestBody User paramObject){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		// validation - userPassword
		if(paramObject.getUserPassword() == null || "".equals(paramObject.getUserPassword())){
			resultMap.put("stat", "error");
			return resultMap;
		}
		
		// 회원가입 진행
		String joinResult = userService.userJoin(paramObject);
		resultMap.put("stat", joinResult);
		return resultMap;
	}

	// 아이디 중복 검사
	@GetMapping("/user/use/{userId}")
	public HashMap<String, Object> isUseUserId(@PathVariable String userId){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		User paramUser = User.builder().userId(userId).build();
		resultMap.put("isUseUserId", userService.isUseUserId(paramUser));
		return resultMap;
	}
}