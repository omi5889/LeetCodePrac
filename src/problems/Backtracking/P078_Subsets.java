package problems.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by omkar on 10/25/18.
 *
 *Given a set of distinct integers, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 Example:

 Input: nums = [1,2,3]
 Output:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 *
 *
 *
 *
 */
public class P078_Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        backtrack(0,nums,new ArrayList<>(),res);

        return res;
    }

    private void backtrack(int start, int[] nums, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for(int i=start; i<nums.length; i++) {
            temp.add(nums[i]);
            backtrack(i+1, nums, temp, res);
            temp.remove(temp.size()-1);
        }
    }


    public static void main(String[] args) {
        P078_Subsets obj = new P078_Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> res = obj.subsets(nums);
        System.out.print(res);

    }
}
