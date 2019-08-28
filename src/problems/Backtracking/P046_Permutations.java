package problems.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omkar on 10/25/18.
 *
 *
 * Given a collection of distinct integers, return all possible permutations.

 Example:

 Input: [1,2,3]
 Output:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 *
 *
 *
 */
public class P046_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> res) {
        if(temp.size()==nums.length) {
            res.add(new ArrayList<>(temp));
        }

        for(int i=0; i<nums.length; i++) {
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backtrack(nums,temp,res);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        P046_Permutations obj = new P046_Permutations();
        int[] nums = {1,2,3};
        List<List<Integer>> res = obj.permute(nums);
        System.out.println(res);
    }
}
