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
	void bbbbb() {
		int longestSubstring = new Solution().lengthOfLongestSubstring("bbbbb");
		Assertions.assertEquals(1, longestSubstring);
	}


	@Test
	void abc() {
		int longestSubstring = new Solution().lengthOfLongestSubstring("abc");
		Assertions.assertEquals(3, longestSubstring);
	}

	@Test
	void abcabc() {
		int longestSubstring = new Solution().lengthOfLongestSubstring("abcabc");
		Assertions.assertEquals(3, longestSubstring);
	}

	@Test
	void abacd(){
		int longestSubstring = new Solution().lengthOfLongestSubstring("abacd");
		Assertions.assertEquals(4, longestSubstring);
	}

	@Test
	void pwwkew(){
		int longestSubstring = new Solution().lengthOfLongestSubstring("pwwkew");
		Assertions.assertEquals(3, longestSubstring);
	}

	@Test
	void empty_space(){
		int longestSubstring = new Solution().lengthOfLongestSubstring(" ");
		Assertions.assertEquals(1, longestSubstring);
	}

	@Test
	void empty(){
		int longestSubstring = new Solution().lengthOfLongestSubstring("");
		Assertions.assertEquals(0, longestSubstring);
	}



}
