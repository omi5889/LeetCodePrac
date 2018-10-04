package problems.Arrays;

import java.util.HashMap;

/**
 * Created by omkar on 10/3/18.
 *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 *
 *
 *
 */
public class P001_TwoSum {

    public int[] twoSum(int[] nums, int target) {

        if(nums.length==2) return new int[]{0,1};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(map.get(target-nums[i])!=null) {
                return new int[]{map.get(target-nums[i]),i};
            } else {
                map.put(nums[i],i);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        P001_TwoSum obj = new P001_TwoSum();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = obj.twoSum(nums, target);
        System.out.print(res[0]+" "+res[1]);
    }

}



