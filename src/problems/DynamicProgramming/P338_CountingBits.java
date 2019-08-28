package problems.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omkar on 4/1/19.
 *
 *Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate
 * the number of 1's in their binary representation and return them as an array.
 *
 Input: 2
 Output: [0,1,1]

 Input: 5
 Output: [0,1,1,2,1,2]
 *
 *
 *
 *Solution: @lixx2100

 *
 *
 *
 *@valentinzhao

 * When it comes to even numbers, i.e, 2,4,6,8, their binary should be like '10', '100', '110', '1000' so one notable difference is their unit digit is always 0, which means when you call >> 1- shift one bit rightwards and also means dividing by 2- would cause no change to the count of '1' in the binary string.

 Vice versa, when you meet odd numbers, shifting one bit rightwards always eliminates one '1' digit from original binary string, that is why we should "compensate" one '1' character to the count.

 To sum up, when you meet even number the count of '1's is always the same as its half number, on the other hand, remember to plus one to the odds' half number.
 *
 *
 *
 */
public class P338_CountingBits {
    public int[] countBits(int num) {
        int[] arr = new int[num+1];

        for(int i=0; i<num+1; i++) {
//            arr[i] = arr[i/2] + (i % 2);
            arr[i] = arr[i >> 1] + (i & 1);
        }

        return arr;
    }

    public List<Integer> getTestcases() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(10);
        return list;
    }

    public static void main(String[] args) {
        P338_CountingBits obj = new P338_CountingBits();
        List<Integer> testcases = obj.getTestcases();
        for(int num: testcases) {
            int[] res = obj.countBits(num);
            for(int i=0; i<res.length; i++) {
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }

    }
}
