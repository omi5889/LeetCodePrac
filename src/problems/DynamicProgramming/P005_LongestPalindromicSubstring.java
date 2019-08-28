package problems.DynamicProgramming;

/**
 * Created by omkar on 5/13/19.
 */
public class P005_LongestPalindromicSubstring {
    public String longestPalindrome(String str) {
        if(str==null || str.equalsIgnoreCase("") || str.length()==1) return str;
        int n = str.length();
        boolean[][] table = new boolean[n][n];
        int maxlength = 1;
        for(int i=0; i<n; i++) {
            table[i][i] = true;
        }

        int start = 0;
        for(int i=0; i<n-1; i++) {
            if(str.charAt(i)==str.charAt(i+1)) {
                table[i][i+1] = true;
                start = i;
                maxlength = 2;
            }
        }

        for(int k=3; k<=n; k++) {
            for(int i=0; i< n-k+1; i++) {
                int j = i + k - 1;
                if(table[i+1][j-1] && str.charAt(i)==str.charAt(j)) {
                    table[i][j] = true;

                    if(k>maxlength) {
                        start = i;
                        maxlength = k;
                    }
                }
            }
        }

        int end = start + maxlength - 1;
        return str.substring(start,end+1);
    }

    public static void main(String[] args){
        P005_LongestPalindromicSubstring obj = new P005_LongestPalindromicSubstring();
        String ip = "qqwweeeerrrtttt";
        String res = obj.longestPalindrome(ip);
        System.out.print("res:: "+res);
    }
}
