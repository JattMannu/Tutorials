package leet.code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new LinkedList<>();
        if(nums.length < 4)
            return lists;


        Arrays.sort(nums);
        if(target < nums[0]+ nums[1]+nums[2] + nums[3] ||
            target > nums[nums.length-1]+ nums[nums.length-2]+nums[nums.length-3] + nums[nums.length-4]){
            return lists;
        }


        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = j + 1;
                int l = nums.length-1;

                while (k < l){
                    if(nums[i]+ nums[j]+nums[k] + nums[l]  == target)
                        lists.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[k],nums[l]}));

                    if(nums[i]+ nums[j]+nums[k] + nums[l]  < target) {
                        while (k < nums.length-1 && nums[k] == nums[k+1]) k++;
                        k++;
                    }
                    else {
                        while (l > 0 && nums[l] == nums[l-1]) l--;
                        l--;
                    }

                }
                while (j < nums.length-1 && nums[j] == nums[j+1]) j++;
            }
            while (i < nums.length-1 && nums[i] == nums[i+1]) i++;
        }
        return lists;
    }
}
