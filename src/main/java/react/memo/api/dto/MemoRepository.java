package react.memo.api.dto;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Integer> {
	ArrayList<Memo> findByOwnerSeq(int ownerId);
}