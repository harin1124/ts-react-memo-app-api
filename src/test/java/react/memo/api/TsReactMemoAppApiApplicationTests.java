package react.memo.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import react.memo.api.dto.Users;

@SpringBootTest
class TsReactMemoAppApiApplicationTests {

	@Test
	void contextLoads() {}

	@Test
	Users userIsNull(){
		return null;
	}
}
