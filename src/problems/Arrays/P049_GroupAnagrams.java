package problems.Arrays;

import java.util.*;

/**
 * Created by omkar on 1/31/19.
 */
public class P049_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length==0) return res;
        Map<String,List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String keystr = String.valueOf(carr);
            if(!map.containsKey(keystr)) {
                map.put(keystr, new ArrayList<>());
            }
            map.get(keystr).add(str);

        }

        for(String str:map.keySet()) {
            res.add(map.get(str));
        }

        return res;
    }

    public static void main(String[] args){
        P049_GroupAnagrams obj = new P049_GroupAnagrams();
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = obj.groupAnagrams(arr);
        for(List<String> curr:ans) {
            System.out.println(curr);
        }
    }
}
