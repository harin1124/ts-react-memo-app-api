package react.memo.api.user.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String userId;
    private String password;
}