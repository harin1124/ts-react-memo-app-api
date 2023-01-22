package react.memo.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import react.memo.api.dto.User;
import react.memo.api.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TsReactMemoAppApiApplicationTests {

	@Test
	void contextLoads() {}

	@Test
	User userIsNull(){
		User paramUser = new User();
		paramUser.setUserId("mcubw");
		paramUser.setUserPassword("mcubw");
		User correctUser = new UserService().getUser(paramUser);

		return correctUser;
	}
}
