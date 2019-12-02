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
	void check_zero() {
		String s = new Solution().intToRoman(0);
		Assertions.assertEquals("" , s);

	}

	@Test
	void check_1() {
		String s = new Solution().intToRoman(1);
		Assertions.assertEquals("I" , s);

	}

	@Test
	void check_4() {
		String s = new Solution().intToRoman(4);
		Assertions.assertEquals("IV" , s);

	}

	@Test
	void check_5() {
		String s = new Solution().intToRoman(5);
		Assertions.assertEquals("V" , s);

	}

	@Test
	void check_10() {
		String s = new Solution().intToRoman(10);
		Assertions.assertEquals("X" , s);
	}

	@Test
	void check_27() {
		String s = new Solution().intToRoman(27);
		Assertions.assertEquals("XXVII" , s);
	}


}
