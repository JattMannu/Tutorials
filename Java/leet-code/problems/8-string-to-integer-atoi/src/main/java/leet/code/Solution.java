package leet.code;

public class Solution {
    public int myAtoi(String str) {
        int value = 0;
        int sign = 1;
        boolean started = false;

        if(str == null)
            return value;

        for (char c : str.toCharArray()) {
            if( c == ' ' && started == false)
                continue;

            else if(c == '-' && started == false) {
                sign = -1;
                started = true;
            }
            else if(c == '+' && started == false) {
                sign = 1;
                started = true;
            }
            else if ( c >= '0' && c <= '9' ) {
                int helper = value;
                value = value * 10 + (c - '0');
                if( value / 10  < helper ){
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                started = true;

            }
            else
                break; //Invalid Chars

        }


        return value * sign;
    }

}
