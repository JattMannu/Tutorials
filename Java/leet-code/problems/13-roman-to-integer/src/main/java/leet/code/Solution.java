package leet.code;

import java.util.*;

public class Solution {
    public int romanToInt(String s) {
        if (s == null)
            return 0;

        int result = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {

            int charValue = 0;
            switch (s.charAt(i)) {
                case 'I':
                    charValue = 1;
                    break;
                case 'V':
                    charValue = 5;
                    break;
                case 'X':
                    charValue = 10;
                    break;
                case 'L':
                    charValue = 50;
                    break;
                case 'C':
                    charValue = 100;
                    break;
                case 'D':
                    charValue = 500;
                    break;
                case 'M':
                    charValue = 1000;
                    break;

            }
            result = result + (charValue * ((charValue < prev) ? -1 : 1));
            prev = charValue;
        }

        return result;
    }


    public static long teamFormation(List<Integer> score, int team_size, int k) {
        if (team_size < 1)
            return 0;

        if (team_size < 0 || team_size > score.size())
            throw new IllegalArgumentException("team_size is larger then number of team members");


        List<Integer> _score = new LinkedList<>();

        for (Integer i : score) {
            _score.add(i);

        }

        List<Integer> left;
        List<Integer> right;

        int left_max = -1;
        int left_idx = -1;

        int right_max = -1;
        int right_idx = -1;


        if (score.size() < k) {
            left = score;
        } else {
            left = score.subList(0, k);

        }
        for (int i = 0; i < left.size(); i++) {
            if (left.get(i) > left_max) {
                left_max = left.get(i);
                left_idx = i;
            }
        }

        if (score.size() > k) {
            right = score.subList(score.size() - k, score.size());

            for (int i = 0; i < right.size(); i++) {
                if (right.get(i) > right_max) {
                    right_max = right.get(i);
                    right_idx = score.size() - k - i;
                }
            }
        }

        int idx = left_max > right_max ? left_idx : right_idx;


        _score.remove(idx);
        return Math.max(left_max, right_max) + Solution.teamFormation(_score, --team_size, k);

    }


    public static int calculateCost(List<Integer> arr, int threshold) {
        List<Integer> _arr = new LinkedList<>();

        for (int _threshold = 1; _threshold <= threshold; _threshold++) {


            for (Integer i : arr) {
                _arr.add(i);

            }
            _arr = _arr.toArray();
            List<Integer> slice;

            List<List<Integer>> slices = new LinkedList<>();

            while(_arr.size() > _threshold){
                slices.add(_arr.subList(0, _threshold));

            }


            slices.forEach(integers ->{
                Integer num1 = integers.stream().max(Comparator.comparingInt(integer -> integer)).get();
            } );

            //int[] array = arr.stream().mapToInt(i->i).toArray();

        }
        //Arrays.sort(array);
        // Write your code here
        return 0;

    }
}

