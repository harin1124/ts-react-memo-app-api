package react.memo.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import react.memo.api.dto.Memo;
import react.memo.api.dto.User;
import react.memo.api.service.MemoService;
import react.memo.api.service.UserService;

import java.util.ArrayList;

@RestController
public class MemoController {
	private final Logger logger = LoggerFactory.getLogger(MemoController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private MemoService memoService;

	/**
	 * 메모 목록 조회
	 * @param userId 메모를 조회하는 유저의 아이디
	 * @return ResponseEntity
	 */
	@GetMapping("/memo/list/{userId}")
	public ResponseEntity<ArrayList<Memo>> getMemoList(@PathVariable String userId){
		// 유저 찾기
		User reqUser = User.builder().userId(userId).build();
		User user = userService.getUser(reqUser);
		if(user.getUserId().equals("")){
			return new ResponseEntity<ArrayList<Memo>>(null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}

		// 메모 목록 조회
		ArrayList<Memo> memoList = memoService.getMemoList(user);
		System.out.println(memoList);
		return ResponseEntity.ok().headers(new HttpHeaders()).body(memoList);
	}
}
