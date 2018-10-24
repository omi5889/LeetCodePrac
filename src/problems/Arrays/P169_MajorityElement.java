package problems.Arrays;

/**
 * Created by omkar on 10/18/18.
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 Example 1:

 Input: [3,2,3]
 Output: 3
 Example 2:

 Input: [2,2,1,1,1,2,2]
 Output: 2
 *
 *
 * Explanation:
 *
 * Given is that the majority element occurs more than n/2 times. Using this we keep track of an element and modify a
 * counter depending on the element encountered.
 *
 */
public class P169_MajorityElement {

    public int majorityElement(int nums[]) {
        int res = 0;
        int cnt = 0;
        for(int n:nums) {
            if(cnt==0) res = n;
            if(n!=res) cnt--;
            else cnt++;
        }
        return res;
    }

    public static void main(String[] args) {
        P169_MajorityElement obj = new P169_MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        int ans = obj.majorityElement(nums);
        System.out.print(ans);
    }

}
