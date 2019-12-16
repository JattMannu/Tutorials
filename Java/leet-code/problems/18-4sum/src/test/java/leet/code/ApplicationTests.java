package leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void test_0000_0() {
		List<List<Integer>> lists = new Solution().fourSum(new int[]{0, 0, 0, 0}, 0);
		Assertions.assertEquals(1,lists.size());
	}

	@Test
	void test_0010_0() {
		List<List<Integer>> lists = new Solution().fourSum(new int[]{0, 0, 1, 0}, 0);
		Assertions.assertEquals(0,lists.size());
	}


	@Test
	void test_000001_0() {
		List<List<Integer>> lists = new Solution().fourSum(new int[]{0, 0, 0, 0,1}, 1);
		Assertions.assertEquals(1,lists.size());
	}

	@Test
	void test_10101010101010101010_1() {
		List<List<Integer>> lists = new Solution().fourSum(new int[]{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0}, 1);
		Assertions.assertEquals(1,lists.size());
	}

}
