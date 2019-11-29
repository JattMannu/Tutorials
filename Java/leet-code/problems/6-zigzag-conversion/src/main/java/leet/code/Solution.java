package leet.code;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String convert(String s, int numRows) {
        if (s.equals("") || s == null)
            return "";

        if (numRows < 2)
            return s;

        List<StringBuilder> map = new LinkedList<>();

        for (int i = 0; i < numRows; i++) {
            map.add(new StringBuilder());
        }

        int index = 0;
        boolean goingDown = true;
        for (int i = 0; i < s.length(); i++) {

            if(index == numRows-1)
                goingDown = false;
            else if(index == 0){
                goingDown = true;
            }

            map.get(index).append(s.charAt(i));

            if(goingDown){
                index++;
            }else {
                index--;
            }




        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {

            builder.append(map.get(i).toString());
        }


        return builder.toString();
    }
}
