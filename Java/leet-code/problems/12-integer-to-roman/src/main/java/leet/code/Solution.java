package leet.code;

public class Solution {
    public String intToRoman(int num) {

        String[] ones = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = new String[]{"", "M", "MM", "MMM"};

        StringBuilder builder = new StringBuilder();


        builder.append(thousands[(num/1000) % 10]);
        builder.append(hundreds[(num/100) % 10]);
        builder.append(tens[(num/10) % 10]);
        builder.append(ones[num%10]);


        return builder.toString();
    }
}


