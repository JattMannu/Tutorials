package leet.code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length < 3)
            return result;


        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2;) {
            int low = i +1;
            int high = nums.length - 1;

            while (low < high){
                if(nums[i] + nums[low] + nums[high] == 0){
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[high] == nums[--high]);
                    while (low < high && nums[low] == nums[++low]);
                }else if(nums[i] + nums[low] + nums[high]  > 0 ){
                    high--;
                }else
                    low++;
            }
            while (i < nums.length-2 && nums[i] == nums[++i]);
        }

        return result;
    }


    public List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0)
            return result;

        Arrays.sort(nums);
        Integer prev = null;
        for (int i = 0; i < nums.length - 2; i++) {
            if(prev != null && prev == nums[i] )
                continue;
            for (int j = i + 1; j < nums.length - 1 ; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                     int delta = nums[i] +  nums[j] + nums[k];
                     if(delta  == 0){
                         result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                     }else if (delta > 0 )
                         break;
                }
            }
            prev = nums[i];
        }

        return result;
    }

    public List<List<Integer>> threeSum1(int[] num) {

        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public int numDecodings1(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }

    public int numDecodings2(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] dp = new int[n];


        dp[0] =  s.charAt(0) != '0' ? 1 : 0;

        if(s.length() == 1)
            return dp[0];

        dp[1] =  Integer.valueOf(s.substring(0, 2)) > 10
                 &&   Integer.valueOf(s.substring(0, 2)) < 27
                ? dp[0]+1 : dp[0] + 0;

        for (int i = 2; i < s.length(); i++) {
            int oneDigit = Integer.valueOf(s.substring(i, i+1));
            int twoDigit = Integer.valueOf(s.substring(i-1, i+1));
            dp[i] = dp[i-1] ;
            if(twoDigit > 10 && twoDigit < 27)
                dp[i] = dp[i-1] + dp[i-2];

        }

        return dp[n-1];
    }
}
