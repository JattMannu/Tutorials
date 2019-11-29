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
		String convert = new Solution().convert("", 13);
		Assertions.assertEquals("" , convert);
	}

	@Test
	void rows_zero() {
		String convert = new Solution().convert("ABCDEF", 0);
		Assertions.assertEquals("ABCDEF" , convert);
	}

	@Test
	void rows_one() {
		String convert = new Solution().convert("ABCDEF", 1);
		Assertions.assertEquals("ABCDEF" , convert);
	}

	@Test
	void rows_zero_and_empty_string() {
		String convert = new Solution().convert("", 0);
		Assertions.assertEquals("" , convert);
	}

	@Test
	void rows_two() {
		String convert = new Solution().convert("ABCDEF", 2);
		Assertions.assertEquals("ACEBDF" , convert);
	}


	@Test
	void rows_three() {
		String convert = new Solution().convert("ABCDEF", 3);
		Assertions.assertEquals("AEBDFC" , convert);
	}

}
