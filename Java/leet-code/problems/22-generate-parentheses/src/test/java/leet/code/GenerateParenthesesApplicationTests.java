package leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class GenerateParenthesesApplicationTests {

    @Test
    void generate_n_0() {
        List<String> result = new Solution().generateParenthesis(0);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void generate_n_1() {
        List<String> result = new Solution().generateParenthesis(1);
        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains("()"));
    }


    @Test
    void generate_n_2() {
        List<String> result = new Solution().generateParenthesis(2);
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains("(())"));
        Assertions.assertTrue(result.contains("()()"));
    }

    @Test
    void generate_n_3() {
        List<String> result = new Solution().generateParenthesis(3);
        Assertions.assertEquals(5, result.size());
        Assertions.assertTrue(result.contains("((()))"));
        Assertions.assertTrue(result.contains("(()())"));
        Assertions.assertTrue(result.contains("(())()"));
        Assertions.assertTrue(result.contains("()(())"));
        Assertions.assertTrue(result.contains("()()()"));
    }
}


class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result = new LinkedList<>();
        if( n == 0)
            return result;
        else if (n == 1)
            result.add("()");
        else if (n == 2) {
            result.add("()()");
            generateParenthesis(1).stream().forEach(s -> result.add("(" + s + ")"));
        } else {

            generateParenthesis(n-1).stream().forEach(s -> result.add("(" + s + ")"));
            for (int i = 1; i < n; i++) {
                List<String> lhs = generateParenthesis(i);
                List<String> rhs = generateParenthesis(n - i);
                for (String lh : lhs) {
                    for (String rh : rhs) {
                        result.add(lh + rh);
                    }
                }

            }
        }
        return new LinkedList<>(new HashSet<>(result));
    }
}