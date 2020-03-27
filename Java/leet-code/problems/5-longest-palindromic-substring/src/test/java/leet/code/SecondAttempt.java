package leet.code;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecondAttempt {

	@Test
	void contextLoads() {
	}

	@Test
	void empty_string() {
		String longestPalindrome = new Solution1().longestPalindrome("");
		assert longestPalindrome.equals("");
	}


	@Test
	void a() {
		String longestPalindrome = new Solution1().longestPalindrome("a");
		assert longestPalindrome.equals("a");
	}


	@Test
	void null_check() {
		String longestPalindrome = new Solution1().longestPalindrome(null);
		assert longestPalindrome.equals("");
	}

	@Test
	void aba() {
		String longestPalindrome = new Solution1().longestPalindrome("aba");
		assert longestPalindrome.equals("aba");
	}


	@Test
	void abcba() {
		String longestPalindrome = new Solution1().longestPalindrome("abcba");
		assert longestPalindrome.equals("abcba");
	}

	@Test
	void abcbabc() {
		String longestPalindrome = new Solution1().longestPalindrome("abcbabc");
		assert longestPalindrome.equals("abcba");
	}

	@Test
	void abba() {
		String longestPalindrome = new Solution1().longestPalindrome("abba");
		assert longestPalindrome.equals("abba");
	}

	@Test
	void bb() {
		String longestPalindrome = new Solution1().longestPalindrome("bb");
		assert longestPalindrome.equals("bb");
	}

	@Test
	void abb() {
		String longestPalindrome = new Solution1().longestPalindrome("abb");
		assert longestPalindrome.equals("bb");
	}

	@Test
	void isPali() {

		int length = new Solution1().isPalindromeCheck("a", 0, 0);
		assert length == 1;
	}


	@Test
	void isPali1() {
		assert new Solution1().isPalindromeCheck("aa", 0, 1) == 2;
	}

}

class Solution1 {
	public String longestPalindrome(String s) {
		int length = 0;

		for (int i = 0; i < s.length(); i++) {
			int r1 = isPalindromeCheck(s, i, i);
			int r2 = isPalindromeCheck(s, i, i + 1);
			int r = Math.max(r1,r2);
			if(length < r){
				length = r;

			}
		}
		return "";
	}

	int isPalindromeCheck(String str, int mid1, int mid2) {

		int result = 0;
		while (mid1 >= 0 && mid2 < str.length() &&  str.charAt(mid1) == str.charAt(mid2)) {
			result = mid2 - mid1 + 1;
			mid1--;
			mid2++;
		}
		return result;
	}
}

