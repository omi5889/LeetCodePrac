package problems.Strings;

import java.util.Stack;

/**
 * Created by omkar on 5/16/19.
 */
public class P020_ValidParenthesis {

    public boolean isValid(String s){

        if(s==null || s.length()==1) return false;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            switch(curr) {
                case '}':
                    if(st.isEmpty() || st.pop()!='{') return false;
                    break;
                case ']':
                    if(st.isEmpty() || st.pop()!='[') return false;
                    break;
                case ')':
                    if(st.isEmpty() || st.pop()!='(') return false;
                    break;
                default:
                    st.push(curr);
                    break;
            }
        }
        return st.isEmpty()? true: false;
    }

    public static void main(String[] args){
        P020_ValidParenthesis obj = new P020_ValidParenthesis();
        String s = "([)]";
        boolean res = obj.isValid(s);
        System.out.println("res: "+res);
    }
}
