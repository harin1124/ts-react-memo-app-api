package react.memo.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import react.memo.api.user.dto.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUserId(String userId);
}