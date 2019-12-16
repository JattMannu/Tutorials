package leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LetterCombinationsOfAPhoneNumberApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void _2() {
		List<String> stringList = new Solution().letterCombinations("2");
		Assertions.assertEquals(3,stringList.size());
	}


	@Test
	void _7() {
		List<String> stringList = new Solution().letterCombinations("7");
		Assertions.assertEquals(4,stringList.size());

	}

	@Test
	void _23() {
		List<String> stringList = new Solution().letterCombinations("23");
		Assertions.assertEquals(9,stringList.size());

	}
}
