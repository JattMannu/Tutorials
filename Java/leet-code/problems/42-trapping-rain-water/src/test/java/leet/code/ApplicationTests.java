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
	void null_check() {
		int trap = new Solution().trap(null);
		Assertions.assertEquals(0,trap);
	}

	@Test
	void length_1() {
		int trap = new Solution().trap(new int[]{1});
		Assertions.assertEquals(0,trap);
	}

	@Test
	void length_2() {
		int trap = new Solution().trap(new int[]{1,1});
		Assertions.assertEquals(0,trap);
	}

	@Test
	void array_101() {
		int trap = new Solution().trap(new int[]{1 , 0 ,1});
		Assertions.assertEquals(1,trap);
	}


	@Test
	void array_10101() {
		int trap = new Solution().trap(new int[]{1 , 0  , 1 , 0,1});
		Assertions.assertEquals(2,trap);
	}

	@Test
	void array_11111() {
		int trap = new Solution().trap(new int[]{1 , 1  , 1 , 1,1});
		Assertions.assertEquals(0,trap);
	}

	@Test
	void array_complex() {
		int trap = new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
		Assertions.assertEquals(6,trap);
	}
}
