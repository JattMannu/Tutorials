package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ApplicationTests {

	Solution solution = new Solution();

	@Test
	void no_numbs() {
		Assertions.assertThrows(IllegalArgumentException.class ,
				() ->  solution.twoSum(new int[]{}, 4));
	}

	@Test
	void one_numbs_array() {
		Assertions.assertThrows(IllegalArgumentException.class ,
				() ->  solution.twoSum(new int[]{4}, 4));
	}


	@Test
	void valid_target_2() {
		int[] nums = {1, 1};
		int[] idxs = solution.twoSum(nums, 2);
		Assertions.assertEquals(2, nums[idxs[0]] + nums[idxs[1]]);
	}


	@Test
	void valid_larger_nums_target_2() {
		int[] nums = {1, 0, 1};
		int[] idxs = solution.twoSum(nums, 2);
		Assertions.assertEquals(2, nums[idxs[0]] + nums[idxs[1]]);
	}




	@Test
	void valid_coplex_nums_target_2() {
		int[] nums = {2, 7, 11, 15};
		int[] idxs = solution.twoSum(nums, 9);
		Assertions.assertEquals(9, nums[idxs[0]] + nums[idxs[1]]);
	}



	@Test
	void valid_mix_nums_target_2() {
		int[] nums = {11, 2, 15 , 7};
		int[] idxs = solution.twoSum(nums, 9);
		Assertions.assertEquals(9, nums[idxs[0]] + nums[idxs[1]]);
	}


	@Test
	void valid_case_1_nums_target_6() {
		int[] nums = {3,2,4};
		int[] idxs = solution.twoSum(nums, 6);
		Assertions.assertEquals(6, nums[idxs[0]] + nums[idxs[1]]);
	}

	class Solution {
		public int[] twoSum(int[] nums, int target) {
			if ( nums.length <= 1 ) throw new IllegalArgumentException("numbs is invalid");

			Map<Integer,Integer> valueToIdx = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				valueToIdx.put(nums[i], i);
			}

			for (int i = 0; i < nums.length; i++) {
				int num = nums[i];

				 if( valueToIdx.get(target-num) != null && valueToIdx.get(target-num)  != i )
				 	return  new int[]{i,valueToIdx.get(target-num)};
			}
			throw new IllegalStateException();
		}
	}
}
