package problems.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by omkar on 4/17/19.
 */
public class P127_WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Set<String> reached = new HashSet<String>();
        if(!wordDict.contains(endWord)) return 0;
        reached.add(beginWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }



    public static void main(String[] args){
        P127_WordLadder obj = new P127_WordLadder();
        int res = 0;
        res = obj.ladderLength("plm","cog", new HashSet<String>(Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})));
        System.out.println(res);

    }
}
