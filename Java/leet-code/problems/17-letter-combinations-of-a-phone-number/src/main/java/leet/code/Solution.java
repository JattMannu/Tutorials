package leet.code;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits.length() == 0)
            return result;
        letterCombinations(digits,"",result);
        return result;
    }

    public void letterCombinations(String digits , String ret ,List<String> result) {
        if(digits.length() == 0) {
            result.add(ret);
            return;
        }

        char c = digits.charAt(0);
        String letters = KEYS[(c - '0')];

        for (int i = 0; i < letters.length(); i++) {
            letterCombinations(digits.substring(1),ret+letters.charAt(i), result );
        }

    }
}
