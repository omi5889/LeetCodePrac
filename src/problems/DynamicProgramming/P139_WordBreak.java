package problems.DynamicProgramming;

import java.util.*;

/**
 * Created by omkar on 2/21/19.
 */
public class P139_WordBreak {

    private boolean wordBreak_DP(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    private boolean wordBreak_BFS(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int n = queue.remove();
                if (n == s.length()) {
                    return true;
                }
                if (!visited.contains(n)) {
                    for (int i = n + 1; i <= s.length(); i++) {
                        if (dict.contains(s.substring(n, i))) {
                            queue.add(i);
                            visited.add(n);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        P139_WordBreak obj = new P139_WordBreak();
        String s = "catsandog";
        List<String> wordDict = Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"});
//        boolean res = obj.wordBreak_BFS(s,wordDict);
        boolean res = obj.wordBreak_DP(s,wordDict);
        System.out.print(res);
    }
}
