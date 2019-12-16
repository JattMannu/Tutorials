package leet.code;

public class Solution {
    public boolean canJump(int[] nums) {

        if (nums == null)
            return false;

        if (nums.length == 1)
            return true;

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach ) return false;
            maxReach = Math.max(maxReach, nums[i] + i);
        }

        return true;
    }


    public boolean canJump1(int[] nums) {

        if (nums == null)
            return false;

        if (nums.length == 1)
            return true;

        int[] canReach = new int[nums.length];
        canReach[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                if (canReach[i] > 0)
                    canReach[i + j] = 1;
                if (canReach[nums.length - 1] == 1)
                    return true;
            }
        }
        return false;
    }
}
