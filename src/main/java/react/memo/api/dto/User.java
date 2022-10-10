package react.memo.api.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@Entity
public class User {
    @Id
    private String userId;
    private String userPassword;

    @Builder
    public User(String userId, String userPassword){
        this.userId = userId;
        this.userPassword = userPassword;
    }
}