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
		boolean b = new Solution().canJump(null);
		Assertions.assertFalse(b);
	}


	@Test
	void one_step_0() {
		boolean b = new Solution().canJump(new int[]{0});
		Assertions.assertTrue(b);
	}

	@Test
	void one_step_1() {
		boolean b = new Solution().canJump(new int[]{1});
		Assertions.assertTrue(b);
	}


	@Test
	void two_step_1() {
		boolean b = new Solution().canJump(new int[]{1,0});
		Assertions.assertTrue(b);
	}

	@Test
	void three_step_1() {
		boolean b = new Solution().canJump(new int[]{1,0 ,1});
		Assertions.assertFalse(b);
	}

	@Test
	void three_step_2() {
		boolean b = new Solution().canJump(new int[]{1,1,1});
		Assertions.assertTrue(b);
	}


	@Test
	void three_step_3() {
		boolean b = new Solution().canJump(new int[]{3,1,1});
		Assertions.assertTrue(b);
	}

	@Test
	void five_step_1() {
		boolean b = new Solution().canJump(new int[]{2,3,1,1,4});
		Assertions.assertTrue(b);
	}

	@Test
	void five_step_2() {
		boolean b = new Solution().canJump(new int[]{3,2,1,0,4});
		Assertions.assertFalse(b);
	}
}
