package react.memo.api.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="T_USER")
public class User {
    @Id
    private String userId;
    @Column
    private String userPassword;

    @Builder
    public User(String userId, String userPassword){
        this.userId = userId;
        this.userPassword = userPassword;
    }
}