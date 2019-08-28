package problems.Arrays;

/**
 * Created by omkar on 6/13/19.
 */
public class P011_ContainerWithMostWater {

    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int currArea = 0, maxArea = 0;
        while(l<r) {
            currArea = Math.min(height[l],height[r]) * Math.abs(r-l);
            if(currArea > maxArea) maxArea = currArea;
            if(height[l]<=height[r]) l++;
            else r--;
        }
        return maxArea;
    }

    public static void main(String[] args){
        P011_ContainerWithMostWater obj = new P011_ContainerWithMostWater();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int res = obj.maxArea(height);
        System.out.print("res::" + res);
    }
}
