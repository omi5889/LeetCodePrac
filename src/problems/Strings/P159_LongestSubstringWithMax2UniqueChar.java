package problems.Strings;

import java.util.HashMap;

/**
 * Created by omkar on 4/29/19.
 */
public class P159_LongestSubstringWithMax2UniqueChar {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 1) return 0;
        HashMap<Character,Integer> index = new HashMap<Character,Integer>();
        int lo = 0;
        int hi = 0;
        int maxLength = 0;
        while(hi < s.length()) {
            if(index.size() <= 2) {
                char c = s.charAt(hi);
                index.put(c, hi);
                hi++;
            }
            if(index.size() > 2) {
                int leftMost = s.length();
                for(int i : index.values()) {
                    leftMost = Math.min(leftMost,i);
                }
                char c = s.charAt(leftMost);
                index.remove(c);
                lo = leftMost+1;
            }
            maxLength = Math.max(maxLength, hi-lo);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        P159_LongestSubstringWithMax2UniqueChar obj = new P159_LongestSubstringWithMax2UniqueChar();
        int res = obj.lengthOfLongestSubstringTwoDistinct("hhhhhhheeelllmmmm");
        System.out.println(res);
    }
}
