package problems.Arrays;

/**
 * Created by omkar on 11/27/18.
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59123/O(N)O(NLogN)-solutions-both-O(1)-space
 */
public class P209_MinimumSizeSubArraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int i=0, j=0, sum=0, min=Integer.MAX_VALUE;

        while(j<nums.length) {
            while(sum<s && j<nums.length) {
                sum += nums[j];
                j++;
            }

            if(sum>=s) {
                while(sum>=s && i<j) {
                    sum -= nums[i];
                    i++;
                }
                min = Math.min(min, j-i+1);
            }
        }

        return min==Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args){
        P209_MinimumSizeSubArraySum obj = new P209_MinimumSizeSubArraySum();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        int res = obj.minSubArrayLen(s,nums);
        System.out.print(res);
    }
}
