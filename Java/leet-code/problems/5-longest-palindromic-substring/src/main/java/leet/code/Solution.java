package leet.code;

import java.util.Arrays;

class Solution_try{
    public String longestPalindrome(String s) {
        int index = 0;
        int maxExpanded = 0;
        if (s == null || s.equals(""))
            return "";

        int[][] matrix = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            matrix[i][i] = 1;
        }


        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1 ; j < s.length() ; j++) {
                if (s.charAt(i) == s.charAt(j) && matrix[i][j - 1] > 0) {
                    matrix[i][j] = matrix[i][j - 1] + 1;
                }
            }
        }

        int x = -1 , y = -1 , max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i ; j < s.length(); j++) {
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        return s.substring(x, y);
    }
}

public class Solution{

    public String longestPalindrome(String s) {
        int index = 0;
        int maxExpanded = 0;
        if (s == null || s.equals(""))
            return "";

        s = convertToOdd(s);

        for (int idx = 0; idx < s.length(); idx++) {
            int helper = expand(s, idx);
            if (maxExpanded < helper) {
                maxExpanded = helper;
                index = idx;
            }

        }
        return s.substring(index - maxExpanded, index + maxExpanded + 1).replaceAll("@", "");
    }

    private int expand(String s, int from) {
        int L = from, R = from;
        int result = 0;

        while (L > 0 && R < s.length() - 1) {
            L = L - 1;
            R = R + 1;
            if (s.charAt(L) != s.charAt(R)) {
                break;
            }
            result++;
        }

        return result;
    }

    private String convertToOdd(String s) {
        StringBuilder builder = new StringBuilder();

        for (Character c : s.toCharArray()) {
            builder.append("@");
            builder.append(c);


        }
        builder.append("@");
        return builder.toString();

    }

}
