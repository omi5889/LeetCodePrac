package problems;

/**
 * Created by omkar on 10/3/18.
 *
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
     Example 1:
     Input:

     "bbbab"
     Output:
     4
 *
 * Explanation:
 *
 * To find the longest palindromic sub sequence we check the first and last character.
 * If same, we check the same for the string from second character to the second last.
 *
 * In the following approach we find the length of palindromic sequence from single character string
 * to the length of the given string. This is  stored in an array [][] such that
 * arr[i][j] will give the longest palindromic from index i to j of the given string.
 * So this is a dynamic approach in which we find solution of smaller problem and use it to find the
 * solution of the original input.
 *
 * We start with string of length 1, ie single character. Since a single character is always a palindrome we mark
 * arr[i][i] = 1
 *
 * Now increase the length of test string by 1, so we check for 2 characters. We will use two pointers,
 * one at the start (i) and one at the end (j). Iterate this from start of input string to the end.
 * For eg for 2 characters index to compare are 0,1 ; 1,2 ; 2,3 ; ....
 * if i = j -> arr[i][j] = 2(counting i and j) + length of sequence between i and j
 *                       = 2 + arr[i+1][j-1]
 * if i!=j we consider 2 cases below and choose the max
 * case 1: discard j and check for string i to j-1
 * case 2: discard i and check for string i+1 to j
 * hence
 * if i = j -> arr[i][j] = max (arr[i][j-1], arr[i+1][j])
 *
 * Continue above till length of test string is equal to length of input string.
 * arr[0][input.length-1] will have the result for the entire string
 *
 */
public class P516_LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {

        // initial checks for the string input
        if(s==null|| s.equalsIgnoreCase("")) return 0;
        if(s.length()==1) return 1;
        int res = 0;
        char[] letter = s.toCharArray();
        int str_len = s.length();
        int[][] arr = new int[str_len][str_len];

        // every single character is a palindrome, so we mark the length as one
        for(int i=0;i<str_len;i++) {
            arr[i][i] = 1;
        }

        // cnt keeps track of substring length that we will check
        // we start we substrings of length 2 and increment it till input length
        int cnt = 1;

        // check for the string lengths
        while(cnt<str_len) {
            for(int i=0; i<str_len-cnt; i++) {
                int j = i+cnt;
                if(letter[i]==letter[j]) {
                    arr[i][j] = 2 + arr[i+1][j-1];
                } else {
                    arr[i][j] = Math.max(arr[i+1][j],arr[i][j-1]);
                }
            }

            cnt++;
        }

        res = arr[0][str_len-1];
        return res;
    }


    public static void main(String[] args) {
        P516_LongestPalindromicSubsequence obj = new P516_LongestPalindromicSubsequence();
        String s = "abcbfbcac";
        int ans = obj.longestPalindromeSubseq(s);
        System.out.print(ans);
    }

}
