package problems.Strings;

/**
 * Created by omkar on 5/21/19.
 */
public class P032_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s==null||s.equalsIgnoreCase("")) return 0;
        int maxlen = 0, left=0, right=0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') left++;
            else right++;
            if(left==right) maxlen = Math.max(maxlen,left+right);
            else if(right>left) {
                left=0;
                right=0;
            }
        }

        left = 0;
        right = 0;

        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i)=='(') left++;
            else right++;
            if(left==right) maxlen = Math.max(maxlen, left+right);
            else if(left>right) {
                left = 0;
                right = 0;
            }
        }
        return maxlen;

    }

    public static void main(String[] args){
        P032_LongestValidParentheses obj = new P032_LongestValidParentheses();
        String s = "(((()))()(";
        int res = obj.longestValidParentheses(s);
        System.out.println("res:: "+res);

    }
}
