package problems.Arrays;

/**
 * Created by omkar on 10/23/18.
 *
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
 * water it is able to trap after raining.

 Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6

 Explanation:

 Instead of looking at the large pockets of water, consider the amount of water at each individual point/index.
 At every point the maximum amount that can be stored will be the minimum of its left side and right side.
 From this we must also remove the height of elevation.
 So for every point compare the height of elevation and of its left side and store max. Same for right side.
 Result = Sum of [ min(left,right) - elevation ] for all index

 */
public class P042_TrappingRainWater {
    public int trap(int[] height) {

        if(height==null || height.length<2) return 0;
        int hlen = height.length;

        int[] larr = new int[hlen];
        int[] rarr = new int[hlen];
        larr[0] = height[0];
        rarr[hlen-1] = height[hlen-1];

        // store the max height from left
        for(int i=1; i<hlen; i++) {
            larr[i] = Math.max(larr[i-1],height[i]);
        }

        // store the max height from right
        for(int i=hlen-2; i>=0; i--) {
            rarr[i] = Math.max(rarr[i+1],height[i]);
        }
        int res = 0;

        // water stored at a point = minimum height at that point - height of elevation at that point
        for(int i=0; i<hlen; i++) {
            res += Math.min(larr[i],rarr[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        P042_TrappingRainWater obj = new P042_TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = obj.trap(height);
        System.out.println(res);
    }
}
