package react.memo.api.memo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import react.memo.api.memo.dto.Memo;
import react.memo.api.memo.repository.MemoRepository;
import react.memo.api.user.dto.Users;
import react.memo.api.user.repository.UserRepository;

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