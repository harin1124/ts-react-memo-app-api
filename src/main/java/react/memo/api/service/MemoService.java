package react.memo.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import react.memo.api.dto.Memo;
import react.memo.api.dto.MemoRepository;
import react.memo.api.dto.User;

import java.util.ArrayList;

@Service
public class MemoService {
	private final Logger logger = LoggerFactory.getLogger(MemoService.class);

    @Autowired
    private MemoRepository memoRepository;
    
    public ArrayList<Memo> getMemoList(User paramUser){
        return memoRepository.findByOwnerId(paramUser.getUserId());
    }
}