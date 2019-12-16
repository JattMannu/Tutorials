package leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.InvalidParameterException;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void null_check() {
        Assertions.assertThrows(InvalidParameterException.class, () -> new Solution().threeSumClosest(null, 0));
    }


    @Test
    void one_item() {
        Assertions.assertThrows(InvalidParameterException.class, () -> new Solution().threeSumClosest(new int[]{1}, 0));
    }

    @Test
    void two_item() {
        Assertions.assertThrows(InvalidParameterException.class, () -> new Solution().threeSumClosest(new int[]{1,2}, 0));
    }

    @Test
    void three_item() {
        int i = new Solution().threeSumClosest(new int[]{1, 2, 3}, 3);
        Assertions.assertEquals(6,i);
    }

    @Test
    void four_item() {
        int i = new Solution().threeSumClosest(new int[]{0,1, 2, 3}, 6);
        Assertions.assertEquals(6,i);
    }

    @Test
    void four_item_1() {
        int i = new Solution().threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        Assertions.assertEquals(2,i);
    }

    @Test
    void four_item_2() {
        int i = new Solution().threeSumClosest(new int[]{0,2,1,-3}, 0);
        Assertions.assertEquals(0,i);
    }

    @Test
    void four_item_3() {
        int i = new Solution().threeSumClosest(new int[]{1,1,1,0}, -100);
        Assertions.assertEquals(2,i);
    }
}
