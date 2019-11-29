package leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void empty_string() {
		int i = new Solution().myAtoi("");
		Assertions.assertEquals(0 , i);
	}

	@Test
	void null_string() {
		int i = new Solution().myAtoi(null);
		Assertions.assertEquals(0 , i);
	}

	@Test
	void positive_123() {
		int i = new Solution().myAtoi("123");
		Assertions.assertEquals(123 , i);
	}


	@Test
	void negative_123() {
		int i = new Solution().myAtoi("-123");
		Assertions.assertEquals(-123 , i);
	}

	@Test
	void positive_spaces_123() {
		int i = new Solution().myAtoi("        123");
		Assertions.assertEquals(123 , i);
	}

	@Test
	void positive_spaces_1_space_23() {
		int i = new Solution().myAtoi("        1 23");
		Assertions.assertEquals(1 , i);
	}


	@Test
	void negative_spaces_123() {
		int i = new Solution().myAtoi("        -123");
		Assertions.assertEquals(-123 , i);
	}

	@Test
	void negative_spaces_12_space_3() {
		int i = new Solution().myAtoi("        -12 3");
		Assertions.assertEquals(-12 , i);
	}

	@Test
	void positive_123_words() {
		int i = new Solution().myAtoi("123 help");
		Assertions.assertEquals(123 , i);
	}

	@Test
	void negative_123_words() {
		int i = new Solution().myAtoi("-123 help");
		Assertions.assertEquals(-123 , i);
	}

	@Test
	void words_positive_123_words() {
		int i = new Solution().myAtoi("help123 help");
		Assertions.assertEquals(0 , i);
	}

	@Test
	void words_negative_123_words() {
		int i = new Solution().myAtoi("help-123 help");
		Assertions.assertEquals(0 , i);
	}

	@Test
	void large_negative_91283472332() {
		int i = new Solution().myAtoi("-91283472332");
		Assertions.assertEquals(Integer.MIN_VALUE , i);
	}

	@Test
	void large_negative_6147483648() {
		int i = new Solution().myAtoi("-6147483648");
		Assertions.assertEquals(Integer.MIN_VALUE , i);
	}

	@Test
	void large_postive_91283472332() {
		int i = new Solution().myAtoi("91283472332");
		Assertions.assertEquals(Integer.MAX_VALUE , i);
	}

	@Test
	void postive_sign_2() {
		int i = new Solution().myAtoi("+2");
		Assertions.assertEquals(2, i);
	}


}
