package react.memo.api.memo.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import react.memo.api.memo.dto.Memo;

public interface MemoRepository extends JpaRepository<Memo, Integer> {
    ArrayList<Memo> findByOwnerSeq(int ownerId);
}