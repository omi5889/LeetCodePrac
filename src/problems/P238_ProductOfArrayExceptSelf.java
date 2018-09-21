package problems;

import java.util.Arrays;

/**
 * Created by omkar on 9/20/18.
 * <p>
 * <p>
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * <p>
 * <p>
 * <p>
 * Explanation:
 * <p>
 * For every index in the array, the final product is the product of all elements before that index and all elements after that index
 * product of index i = product(0...i-1) * product(i+1...arr.len -1)
 * <p>
 * To get this, the input array is passed through 2 times, one time from left and second time from right
 * During each pass, a running product is tracked.
 * At the start of each pass the product is initialized to 1 since there are no elements before the starting element.
 * This is then consequently multiplied with the element from the input array till end of array.
 * Reinitialize the product to 1 and repeat above process from right to left.
 */
public class P238_ProductOfArrayExceptSelf {

    private void disp(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private int[] productExceptSelf(int[] arr) {
        if (arr.length <= 1) return arr;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            res[i] = 1;
        int prod = 1;

        for (int i = 0; i < arr.length; i++) {
            res[i] *= prod;
            prod *= arr[i];
        }

        prod = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] *= prod;
            prod *= arr[i];
        }

        return res;
    }

    public static void main(String[] args) {
        P238_ProductOfArrayExceptSelf obj = new P238_ProductOfArrayExceptSelf();
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {};
        int[] arr3 = {10};
        obj.disp(obj.productExceptSelf(arr1));
        System.out.println();
        obj.disp(obj.productExceptSelf(arr2));
        System.out.println();
        obj.disp(obj.productExceptSelf(arr3));
    }
}
