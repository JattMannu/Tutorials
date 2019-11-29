package leet.code;

public class Solution {
    public int trap(int[] height) {
        if (height == null)
            return 0;

        if (height.length < 3)
            return 0;

        int i = 0;
        int j = height.length - 1;
        int sideL = 0;
        int sideR = 0;
        int minSide;

        int trappedwater = 0;

        while (i < j){

            sideL = Math.max(sideL,height[i]);
            sideR = Math.max(sideR,height[j]);
            minSide = Math.min(sideL,sideR);

            if(minSide > height[i])
                trappedwater += minSide - height[i];
            else if (minSide > height[j])
                trappedwater += minSide - height[j];


            if( height[i] < height[j])
                i++;
            else
                j--;

        }
        return  trappedwater;
    }
}
