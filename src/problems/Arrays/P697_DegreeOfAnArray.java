package problems.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by omkar on 4/1/19.
 *
 *
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

 Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 Input: [1, 7, 7, 5, 7, 1]
 Output: 4
 Explanation: The degree of this array is 3 because 7 appears the most of any number.
 The shortest subarray that you can make that has a degree of 3 is [7,7,5,7].
 The length of that subarray is 4, so we return 4.


 *
 *
 */
public class P697_DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return 1;
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {

            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{1,i,i});
            } else {
                int[] temp = map.get(nums[i]);
                temp[0]++;
                temp[2] = i;
                map.put(nums[i],temp);
            }

        }
        int degree = Integer.MIN_VALUE, res = nums.length;
        for (int[] value : map.values()){
            if (value[0] > degree){
                degree = value[0];
                res = value[2] - value[1] + 1;
            } else if (value[0] == degree){
                res = Math.min( value[2] - value[1] + 1, res);
            }
        }
        return res;

    }

    public List<int[]> getTestCases() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{});
        list.add(new int[]{5});
        list.add(new int[]{1,1,1,1,1});
        list.add(new int[]{1,2,3,4,5,6,7,8,9,0});
        list.add(new int[]{1,2,2,3,1});
        return list;
    }

    public static void main(String[] args){
        P697_DegreeOfAnArray obj = new P697_DegreeOfAnArray();
        List<int[]> testcases = obj.getTestCases();
        for(int[] nums: testcases) {
            int res = obj.findShortestSubArray(nums);
            System.out.println("res:: "+res);
        }

    }
}
