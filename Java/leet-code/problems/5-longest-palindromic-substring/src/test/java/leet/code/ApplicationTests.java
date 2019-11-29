package leet.code;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void empty_string() {
		String longestPalindrome = new Solution().longestPalindrome("");
		assert  longestPalindrome.equals("");
	}


	@Test
	void a() {
		String longestPalindrome = new Solution().longestPalindrome("a");
		assert  longestPalindrome.equals("a");
	}


	@Test
	void null_check() {
		String longestPalindrome = new Solution().longestPalindrome(null);
		assert  longestPalindrome.equals("");
	}

	@Test
	void aba() {
		String longestPalindrome = new Solution().longestPalindrome("aba");
		assert  longestPalindrome.equals("aba");
	}


	@Test
	void abcba() {
		String longestPalindrome = new Solution().longestPalindrome("abcba");
		assert  longestPalindrome.equals("abcba");
	}

	@Test
	void abcbabc() {
		String longestPalindrome = new Solution().longestPalindrome("abcbabc");
		assert  longestPalindrome.equals("abcba");
	}

	@Test
	void abba() {
		String longestPalindrome = new Solution().longestPalindrome("abba");
		assert  longestPalindrome.equals("abba");
	}

	@Test
	void bb() {
		String longestPalindrome = new Solution().longestPalindrome("bb");
		assert  longestPalindrome.equals("bb");
	}

	@Test
	void abb() {
		String longestPalindrome = new Solution().longestPalindrome("abb");
		assert  longestPalindrome.equals("bb");
	}

}


