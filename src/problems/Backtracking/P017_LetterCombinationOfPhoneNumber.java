package problems.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by omkar on 10/23/18.
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *Input: "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */
public class P017_LetterCombinationOfPhoneNumber {
    HashMap<Character,char[]> hmap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0) return res;

        hmap.put('2', new char[]{'a','b','c'});
        hmap.put('3', new char[]{'d','e','f'});
        hmap.put('4', new char[]{'g','h','i'});
        hmap.put('5', new char[]{'j','k','l'});
        hmap.put('6', new char[]{'m','n','o'});
        hmap.put('7', new char[]{'p','q','r','s'});
        hmap.put('8', new char[]{'t','u','v'});
        hmap.put('9', new char[]{'w','x','y','z'});

        char[] arr = new char[digits.length()];

        helper(digits,0,res,arr);

        return res;
    }

    private void helper(String digits, int index, List<String> res, char[] arr) {
        if(index==digits.length()) {
            res.add(new String(arr));
            return;
        }

        char digit = digits.charAt(index);
        char[] temp = hmap.get(digit);
        for(int i=0; i<temp.length; i++) {
            arr[index] = temp[i];
            helper(digits,index+1, res,arr);
        }

    }

    public static void main(String[] args) {
        P017_LetterCombinationOfPhoneNumber obj = new P017_LetterCombinationOfPhoneNumber();
        String digits = "23";
        List<String> res = obj.letterCombinations(digits);
        System.out.print(res);
    }
}
