package react.memo.api;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import react.memo.api.user.dto.Users;
import react.memo.api.user.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTest {
  @Autowired
  private UserRepository userRepository;

  // TODO : 이 부분이 리스트이면, 추후 더 많은 테스트에 용이하므로 수정 고려할 것
  Users defaultUser;

  /**
   * 테스트 수행 전, 기본 유저 저장
   */
  @BeforeAll
  public void userSetUp(){
    Users user = new Users();
    user.setUserId("jane");
    user.setUserRole("ROLE_USER");
    user.setPassword(new BCryptPasswordEncoder().encode("jane"));

    userRepository.saveAndFlush(user);

    this.defaultUser = user;
  }

  /**
   * 유저 관련 테스트 수행 후, 기본 유저 삭제
   */
  @AfterAll
  public void setUpUserDelete(){
    userRepository.delete(this.defaultUser);
  }

  @Test
  public void 유저_회원가입_후_정상조회_확인(){
    Users findUser = userRepository.findByUserId("jane");

    // 동일해야 테스트 통과
    assertEquals(defaultUser, findUser);
  }

  @Test
  public void 아이디_중복확인_결과_중복(){
    Users findUser = userRepository.findByUserId("jane");

    // 동일해야 테스트 통과
    assertEquals(defaultUser, findUser);
  }

  @Test
  public void 아이디_중복확인_결과_중복아님(){
    String tryUserId = "jane_jane";
    Users findUser = userRepository.findByUserId(tryUserId);

    // 동일해야 테스트 통과
    assertNull(findUser);
  }
}