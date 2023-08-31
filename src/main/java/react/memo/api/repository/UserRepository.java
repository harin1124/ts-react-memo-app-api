package react.memo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import react.memo.api.dto.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUserId(String userId);
}