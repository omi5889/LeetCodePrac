package problems.Backtracking;

import java.util.Arrays;

/**
 * Created by omkar on 1/24/19.
 */
public class P044_WildcardMatching {
    public boolean isMatch(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();

        if(m==0) return n==0;

        boolean[][] lookup = new boolean[n+1][m+1];

        for(int i=0;i<n+1;i++) {
            Arrays.fill(lookup[i],false);
        }

        lookup[0][0] = true;

        for (int j = 1; j <= m; j++)
            if (pattern.charAt(j - 1) == '*')
                lookup[0][j] = lookup[0][j - 1];

        disp(lookup,n,m);

        // fill the table in bottom-up fashion
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pattern.charAt(j - 1) == '*')
                    lookup[i][j] = lookup[i][j - 1] ||
                            lookup[i - 1][j];

                    // Current characters are considered as
                    // matching in two cases
                    // (a) current character of pattern is '?'
                    // (b) characters actually match
                else if (pattern.charAt(j - 1) == '?' ||
                        str.charAt(i - 1) == pattern.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1];

                    // If characters don't match
                else lookup[i][j] = false;
            }
            disp(lookup,n,m);
        }

        return lookup[n][m];

    }

    public void disp(boolean[][] lookup, int n, int m) {
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++) {
                System.out.print(lookup[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("===========================");
    }

    public static void main(String[] args){
        P044_WildcardMatching obj = new P044_WildcardMatching();
        String str = "aa";
        String pattern = "*";
        boolean res = obj.isMatch(str,pattern);
        System.out.print(res);
    }
}
