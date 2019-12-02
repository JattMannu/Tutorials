package leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void null_check() {
		int i = new Solution().romanToInt(null);
		Assertions.assertEquals(0,i);
	}


	@Test
	void I() {
		int i = new Solution().romanToInt("I");
		Assertions.assertEquals(1,i);
	}

	@Test
	void IV() {
		int i = new Solution().romanToInt("IV");
		Assertions.assertEquals(4,i);
	}

	@Test
	void VII() {
		int i = new Solution().romanToInt("VII");
		Assertions.assertEquals(7,i);
	}

	@Test
	void asda() {
		try
		{
			Float f1 = new Float("3.0");
			int x = f1.intValue();
			byte b = f1.byteValue();
			double d = f1.doubleValue();
			System.out.println(x + b + d);
		}
		catch (NumberFormatException e) /* Line 9 */
		{
			System.out.println("bad number"); /* Line 11 */
		}
	}


	@Test
	void asda11() {
		List<Integer> integers = new LinkedList<>();
		integers.add(9);
		integers.add(17);
		integers.add(12);
		integers.add(10);
		integers.add(2);
		integers.add(7);
		integers.add(2);
		integers.add(11);
		integers.add(20);
		integers.add(8);
		integers.add(3);
		integers.add(4);
		long l = Solution.teamFormation(integers, 3, 4);
		System.out.println(l);
	}


	@Test
	void asda12() {
		List<Integer> integers = new LinkedList<>();
		integers.add(8);
		integers.add(6);
		integers.add(18);
		integers.add(8);
		integers.add(14);
		integers.add(10);
		integers.add(12);
		integers.add(18);
		integers.add(9);
		integers.add(8);
		integers.add(3);
		long l = Solution.teamFormation(integers, 8, 3);
		System.out.println(l);
	}



	@Test
	void asda13() {
		List<Integer> integers = new LinkedList<>();
		integers.add(8);
		integers.add(6);
		integers.add(18);
		long l = Solution.teamFormation(integers, 1, 3);
		Assertions.assertEquals(18 , l);
	}

	@Test
	void asda14() {
		List<Integer> integers = new LinkedList<>();
		integers.add(8);
		long l = Solution.teamFormation(integers, 1, 1);
		Assertions.assertEquals(8 , l);
	}

	@Test
	void asda15() {
		List<Integer> integers = new LinkedList<>();
		integers.add(8);
		integers.add(6);
		integers.add(18);
		long l = Solution.teamFormation(integers, 2, 3);
		Assertions.assertEquals(18+8 , l);
	}



	@Test
	void aasd1() {
		List<Integer> integers = new LinkedList<>();
		integers.add(8);
		integers.add(6);
		integers.add(18);
		integers.add(8);
		integers.add(14);
		integers.add(10);
		integers.add(12);
		integers.add(18);
		integers.add(9);
		integers.add(8);
		integers.add(3);
		long l = Solution.calculateCost( integers, 1 );
		System.out.println(l);
	}



}

