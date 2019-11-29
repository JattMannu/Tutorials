package leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void null_check() {
		int maxArea = new Solution().maxArea(null);
		Assertions.assertEquals(0, maxArea);
	}

	@Test
	void zero_length() {
		int maxArea = new Solution().maxArea(new int[0]);
		Assertions.assertEquals(0, maxArea);
	}


	@Test
	void all_zeros() {
		int maxArea = new Solution().maxArea(new int[8]);
		Assertions.assertEquals(0, maxArea);
	}

	@Test
	void check_1() {
		int maxArea = new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
		Assertions.assertEquals(49, maxArea);
	}

	@Test
	void negative_number_in_the_list() {
		int maxArea = new Solution().maxArea(new int[]{1,8,6,2,5,4,8,-3,7});
		Assertions.assertEquals(49, maxArea);
	}

}
