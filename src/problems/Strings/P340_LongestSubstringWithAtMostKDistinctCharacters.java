package problems.Strings;

import java.util.HashMap;

/**
 * Created by omkar on 5/22/19.
 */
public class P340_LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null) return 0;
        if(s.length()<k) return s.length();
        HashMap<Character, Integer> hmap = new HashMap<>();
        int maxlen = 0, hi = 0, lo = 0;
        while(hi<s.length()) {
            if(hmap.size()<=k) {
                char c = s.charAt(hi);
                hmap.put(c,hi);
                hi++;
            }
            if(hmap.size()>k) {
                int leftmost = s.length();
                for(int i: hmap.values()) {
                    leftmost = Math.min(leftmost,i);
                }
                char c = s.charAt(leftmost);
                hmap.remove(c);
                lo = leftmost+1;
            }
            maxlen = Math.max(maxlen,hi-lo);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        P340_LongestSubstringWithAtMostKDistinctCharacters obj = new P340_LongestSubstringWithAtMostKDistinctCharacters();
        String s = "asddfrdddaa";
        int k = 2;
        int res = obj.lengthOfLongestSubstringKDistinct(s,k);
        System.out.println(res);
    }
}
