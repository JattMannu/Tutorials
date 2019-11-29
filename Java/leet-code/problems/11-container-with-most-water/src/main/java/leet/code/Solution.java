package leet.code;

public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        if(height == null)
            return 0;

        for (int idx = 0 , xdi = height.length-1 ; idx < xdi ; ) {
            int mininumHeight = Math.min(height[idx], height[xdi]);
            int width = xdi - idx;
            int currentArea = width  * mininumHeight;
            max = Math.max(max,currentArea);

            if(height[idx] < height[xdi])
                idx++;
            else
                xdi--;
        }


        return max;
    }
}
