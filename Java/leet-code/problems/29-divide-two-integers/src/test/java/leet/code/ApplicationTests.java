package leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    private Solution solution = new Solution();

    @Test
    void divide_1_with_1() {
        int result = solution.divide(1, 1);
        Assertions.assertEquals(1, result);
    }

    @Test
	void divide_2_with_1() {
		int result = solution.divide(2, 1);
		Assertions.assertEquals(2, result);
	}

	@Test
	void divide_3_with_1() {
		int result = solution.divide(3, 1);
		Assertions.assertEquals(3, result);
	}

	@Test
	void divide_2_with_2() {
		int result = solution.divide(2, 2);
		Assertions.assertEquals(1, result);
	}


	@Test
	void divide_4_with_2() {
		int result = solution.divide(4, 2);
		Assertions.assertEquals(2, result);
	}


	@Test
	void divide_5_with_2() {
		int result = solution.divide(5, 2);
		Assertions.assertEquals(2, result);
	}

	@Test
	void divide_7_with_3() {
		int result = solution.divide(7, 3);
		Assertions.assertEquals(2, result);
	}

	@Test
	void divide_2_with_negative_1() {
		int result = solution.divide(2, -1);
		Assertions.assertEquals(-2, result);
	}


	@Test
	void divide_negative_2_with_negative_1() {
		int result = solution.divide(-2, -1);
		Assertions.assertEquals(2, result);
	}

	@Test
	void divide_7_with_negative_3() {
		int result = solution.divide(7, -3);
		Assertions.assertEquals(-2, result);
	}

	@Test
	void divide_INTMAX_with_1() {
		int result = solution.divide(Integer.MAX_VALUE, 1);
		Assertions.assertEquals(Integer.MAX_VALUE, result);
	}

	@Test
	void divide_INTMIN_with_1() {
		int result = solution.divide(Integer.MIN_VALUE, 1);
		Assertions.assertEquals(Integer.MIN_VALUE, result);
	}

	@Test
	void divide_INTMAX_with_negative_1() {
		int result = solution.divide(Integer.MAX_VALUE, -1);
		Assertions.assertEquals(Integer.MAX_VALUE*-1, result);
	}

	@Test
	void divide_INTMIN_with_negative_1() {
		int result = solution.divide(Integer.MIN_VALUE, -1);
		Assertions.assertEquals(Integer.MAX_VALUE, result);
	}

	@Test
	void divide_INTMIN_with_2() {
		int result = solution.divide(Integer.MIN_VALUE, 2);
		Assertions.assertEquals(Integer.MIN_VALUE/2, result);
	}


	@Test
	void divide_INTMIN_with_negative_2() {
		int result = solution.divide(Integer.MIN_VALUE, -2);
		Assertions.assertEquals(Integer.MIN_VALUE/-2, result);
	}

}


class Solution {
    public int divide(int dividend, int divisor) {
    	int is_dividend_negative = dividend > 0 ? 1 : -1;
		int is_divisor_negative = divisor > 0 ? 1 : -1;

		if(divisor == 1)
			return dividend;
		else if (divisor == -1 && dividend == Integer.MIN_VALUE)
			return Integer.MAX_VALUE;
		else if (divisor == -1 && dividend == Integer.MAX_VALUE)
			return Integer.MIN_VALUE+1;
		else {
//			//Convert negative to positive
//			dividend = dividend = dividend * is_dividend_negative;
			divisor = divisor * is_divisor_negative;

			int result = 0;
			for (int i = divisor; i <= dividend; i += divisor) {
				if( i  > dividend)
					continue;
				result += 1;
			}
			for (int i = dividend; i < 0; i += divisor) {
				if(i > 0 )
					continue;
				result += 1;
			}
			return result * is_dividend_negative * is_divisor_negative;
		}
    }
}