package problems.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by omkar on 10/25/18.
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 Example:

 Input: [1,1,2]
 Output:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]

 *
 *
 *
 */
public class P047_PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        int arrLen = nums.length;
        boolean[] used = new boolean[arrLen];
        Arrays.sort(nums);
        backtrack(nums, used, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> res) {

        if(temp.size()==nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(used[i]) continue;
            if(i>0 && nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i] = true;
            temp.add(nums[i]);
            backtrack(nums,used,temp,res);
            used[i] = false;
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args){
        P047_PermutationsII obj = new P047_PermutationsII();
        int[] nums = {1,1,2};
        List<List<Integer>> res = obj.permuteUnique(nums);
        System.out.println(res);
    }
}
