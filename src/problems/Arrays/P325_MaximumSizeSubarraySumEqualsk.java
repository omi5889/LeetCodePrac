package problems.Arrays;

import java.util.HashMap;

/**
 * Created by omkar on 11/27/18.
 */
public class P325_MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0, sum = 0;
        for(int i=0;i<nums.length;i++) {
            sum = sum + nums[i];
            if(sum==k) max=i+1;
            else if(map.containsKey(sum-k)) max = Math.max(max,i-map.get(sum-k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }

    public static void main(String[] args) {
        P325_MaximumSizeSubarraySumEqualsk obj = new P325_MaximumSizeSubarraySumEqualsk();
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        int res = obj.maxSubArrayLen(nums,k);
        System.out.print(res);
    }
}
