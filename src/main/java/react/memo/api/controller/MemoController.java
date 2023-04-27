package react.memo.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import react.memo.api.dto.Memo;
import react.memo.api.service.MemoService;
import java.util.ArrayList;

@RestController
public class MemoController {
	private final Logger logger = LoggerFactory.getLogger(MemoController.class);

	@Autowired
	private MemoService memoService;

	/**
	 * 메모 목록 조회
	 * @param id 메모를 조회하는 멤버의 아이디
	 * @return ResponseEntity
	 */
	@GetMapping("/memo/list/{id}")
	public ResponseEntity<ArrayList<Memo>> getMemoList(@PathVariable String id){
		// 메모 목록 조회
		ArrayList<Memo> memoList = memoService.getMemoList(null);
		return ResponseEntity.ok().headers(new HttpHeaders()).body(memoList);
	}
}
