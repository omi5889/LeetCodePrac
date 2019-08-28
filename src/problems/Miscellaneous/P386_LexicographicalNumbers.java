package problems.Miscellaneous;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omkar on 5/2/19.
 */
public class P386_LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1; i<10; i++) {
            dfs(n,i,res);
        }
        return res;
    }

    private void dfs(int n, int curr, List<Integer> res) {
        if(curr>n) return;
        else {
            res.add(curr);
            for(int i=0; i<10; i++) {
                dfs(n,(10*curr)+i, res);
            }
        }
    }


    public static void main(String[] args) {
        P386_LexicographicalNumbers obj = new P386_LexicographicalNumbers();
        int n = 13;
        List<Integer> list = obj.lexicalOrder(n);
        System.out.print(list);
    }
}
