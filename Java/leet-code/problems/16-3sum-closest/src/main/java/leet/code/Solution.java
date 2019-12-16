package leet.code;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            throw new InvalidParameterException("Invalid");

        if (nums.length == 3)
            return nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);


        int idx1 = 0;
        int idx2 = 1;
        int idx3 = nums.length - 1;
        int sum = (nums[idx1] + nums[idx2] + nums[idx3]);
        int delta = target - (nums[idx1] + nums[idx2] + nums[idx3]);
        int minDeta = Math.abs(delta);

        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int value = nums[i] + nums[low] + nums[high];
                if(value == target)
                    return value;

                if(Math.abs(target - value )< minDeta) {
                    minDeta = Math.abs(target - value );
                    sum = value;
                }

                if (value < target){
                    low++;
                }else{
                    high--;
                }



            }

        }

        return sum;
    }

    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<nums.length-2;i++){
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]== target){
                    sum=nums[i]+nums[l]+nums[r];
                    return sum;
                }
                else if(nums[i]+nums[l]+nums[r] < target){
                    if(target - (nums[i]+nums[l]+nums[r]) < diff){
                        diff = target - (nums[i]+nums[l]+nums[r]);
                        sum = nums[i]+nums[l]+nums[r];
                    }
                    l++;
                }
                else{
                    if((nums[i]+nums[l]+nums[r]) - target < diff){
                        diff = (nums[i]+nums[l]+nums[r]) - target;
                        sum = nums[i]+nums[l]+nums[r];
                    }
                    r--;
                }
            }
        }

        return sum;
    }
}
