package problems.Arrays;

/**
 * Created by omkar on 10/18/18.
 *
 *
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.

 Example:

 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 Follow up:

 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 which is more subtle.
 *
 *
 * Explanation:
 *
 * To solve this, for every element in the array keep a track of the running sum and
 * keep updating the max sum.
 *
 *
 */
public class P053_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int currSum = nums[0], maxSum = nums[0];
        for(int i=1;i<nums.length;i++) {
            currSum = Math.max(currSum+nums[i], nums[i]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        P053_MaximumSubarray obj = new P053_MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = obj.maxSubArray(nums);
        System.out.println(ans);
    }
}
