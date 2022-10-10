package react.memo.api.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import react.memo.api.dto.User;
import react.memo.api.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/user")
	@ResponseBody
	public HashMap<String, Object> userJoin(@RequestBody User paramObject){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		System.out.println(paramObject);

		// validation - userPassword
		if(paramObject.getUserPassword() == null || "".equals(paramObject.getUserPassword())){
			resultMap.put("stat", "error");	
			return resultMap;
		}
		
		// 회원가입 진행
		userService.userJoin(paramObject);

		resultMap.put("stat", "success");
		return resultMap;
	}
}