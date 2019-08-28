package problems.Strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by omkar on 5/2/19.
 */
public class P266_PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        if(s==null) return false;
        if(s.length()==1 || s.equalsIgnoreCase("")) return true;
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        return set.size()>1 ? false : true;
    }

    public static void main(String[] args) {
        P266_PalindromePermutation obj = new P266_PalindromePermutation();
        String s = "carerac";
        boolean res = obj.canPermutePalindrome(s);
        System.out.print(res);
    }
}
