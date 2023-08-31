package react.memo.api.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import react.memo.api.dto.Memo;
import react.memo.api.dto.MemoRepository;
import react.memo.api.dto.Users;
import react.memo.api.repository.UserRepository;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;
    private final UserRepository userRepository;
    
    public ArrayList<Memo> getMemoList(String userId){
        // 아이디로 유저 정보 가져오기
        Users user = userRepository.findByUserId(userId);
        return memoRepository.findByOwnerSeq(user.getUserSeq());
    }
}