package leet.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int lengthOfLongestSubstring_1(String s) {

        int maxSize = 0;
        Set<Character> set = new HashSet<>();
        int idx_back = 0;
        int idx_front = 0;
        while (idx_front < s.length())
        {
            if(set.contains(s.charAt(idx_front)) == false){
                set.add(s.charAt(idx_front));
                maxSize = Math.max(maxSize,set.size());
                idx_front++;
            }else {
                set.remove(s.charAt(idx_back));
                idx_back++;
            }

        }

        return maxSize;
    }


    public int lengthOfLongestSubstring(String s) {

        int maxSize = 0;
        Queue<Character> q = new LinkedList<>();
        for (int idx = 0; idx <  s.length();) {

            if(q.contains(s.charAt(idx)) == false){
                q.add(s.charAt(idx++));
                maxSize = Math.max(maxSize,q.size());
            }else {
                q.remove();
            }
        }
        return maxSize;
    }


    public int lengthOfLongestSubstring_old(String s) {

        int maxSize = 0;
        Set<Character> set = new HashSet<>();
        for (int idx = 0; idx < s.length(); idx++) {
            for (int innerIdx = idx; innerIdx < s.length(); innerIdx++) {
                if (set.contains(s.charAt(innerIdx))) {
                    break;
                }
                set.add(s.charAt(innerIdx));
            }
            maxSize = Math.max(maxSize, set.size());
            set.clear();
        }
        return maxSize;
    }
}
