package problems.Strings;

import java.util.HashMap;

/**
 * Created by omkar on 5/15/19.
 */
public class P003_LongestSubstringWithoutRepeatingCharacters {

    // method 1 - using hashmap
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1729/11-line-simple-Java-solution-O(n)-with-explanation
    public int lengthOfLongestSubstring1(String s) {
        if(s==null || s.equalsIgnoreCase("") || s.length()==0) return 0;
        if(s.length()==1) return 1;
        HashMap<Character,Integer> cmap = new HashMap<>();
        int j=0, max=0;
        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            if(cmap.containsKey(curr)) {
                j = Math.max(j,cmap.get(curr)+1);
            }
            cmap.put(curr,i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }

    // method 2 - using substrings
    public int lengthOfLongestSubstring2(String s) {
        if(s==null || s.equalsIgnoreCase("") || s.length()==0) return 0;
        if(s.length()==1) return 1;
        String str = "";
        int max = 0, temp = 0, head=0;
        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            if(str.indexOf(curr)!=-1) {
                head += str.indexOf(curr) + 1;
                str = s.substring(head,i);
                temp = str.length();
            }
            temp++;
            str += curr;
            max = Math.max(max,temp);
        }
        return max;
    }

    public static void main(String[] args) {
        P003_LongestSubstringWithoutRepeatingCharacters obj = new P003_LongestSubstringWithoutRepeatingCharacters();
        String str = "abbacdabb";
        int res1 = obj.lengthOfLongestSubstring1(str);
        System.out.println("res1:: "+res1);
//        int res2 = obj.lengthOfLongestSubstring2(str);
//        System.out.println("res2:: "+res2);
    }
}
