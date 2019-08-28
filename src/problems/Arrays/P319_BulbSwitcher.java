package problems.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omkar on 4/1/19.
 *
 * There are n bulbs that are initially off. You first turn on all the bulbs.
 * Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
 * For the i-th round, you toggle every i bulb. For the n-th round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 *
 *
 Input: 3
 Output: 1
 Explanation:
 At first, the three bulbs are [off, off, off].
 After first round, the three bulbs are [on, on, on].
 After second round, the three bulbs are [on, off, on].
 After third round, the three bulbs are [on, off, off].

 So you should return 1, because there is only one bulb is on.
 *
 * https://leetcode.com/problems/bulb-switcher/discuss/77104/Math-solution..
 *
 *
 A bulb ends up on off if it is switched an odd number of times.

 Call them bulb 1 to bulb n. Bulb i is switched in round d if and only if d divides i.
 So bulb i ends up on if and only if it has an odd number of divisors.

 Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and 3 and 4.
 Except when i is a square, like 36 has divisors 1 and 36, 2 and 18, 3 and 12, 4 and 9, and double divisor 6.
 So bulb i ends up on if and only if i is a square.

 So just count the square numbers.

 Let R = int(sqrt(n)). That's the root of the largest square in the range [1,n]. And 1 is the smallest root.
 So you have the roots from 1 to R, that's R roots. Which correspond to the R squares. So int(sqrt(n)) is the answer.
 (C++ does the conversion to int automatically, because of the specified return type).
 *
 *
 */
public class P319_BulbSwitcher {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public List<Integer> getTestcases(){
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(35);
        return list;
    }

    public static void main(String[] args){
        P319_BulbSwitcher obj = new P319_BulbSwitcher();
        List<Integer> testcases = obj.getTestcases();
        for(int num: testcases) {
            int res = obj.bulbSwitch(num);
            System.out.println(res);
        }
    }
}
