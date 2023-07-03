package react.memo.api.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
public class Users {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int userSeq;
  private String userId;
  private String password;
  private String userRole;

  public List<String> getRoleList(){
    if(this.userRole.length() > 0){
      return Arrays.asList(this.userRole.split(","));
    }
    return new ArrayList<>();
  }
}