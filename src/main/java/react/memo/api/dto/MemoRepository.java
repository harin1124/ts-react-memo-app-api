package react.memo.api.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface MemoRepository extends JpaRepository<Memo, String> {
	ArrayList<Memo> findByOwnerId(String id);
}