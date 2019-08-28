package problems.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by omkar on 4/1/19.
 */
public class P500_KeyboardRow {
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        if(words==null || words.length==0) return list.toArray(new String[list.size()]);

        String[] rows = new String[]{"qwertyuiop","asdfghjkl","zxcvbnm"};

        for(int i=0; i<words.length; i++) {
            if(words[i].equalsIgnoreCase("")) continue;
            int r = 0;
            boolean flag = true;
            char c = words[i].toLowerCase().charAt(0);
            for(int j=0; j<3; j++) {
                if(rows[j].indexOf(c)!=-1) {
                    r = j;
                    break;
                }
            }
            for(int j=1; j<words[i].length(); j++) {
                if(rows[r].indexOf(words[i].toLowerCase().charAt(j))==-1) {
                    flag = false;
                    break;
                }
            }
            if(flag) list.add(words[i]);
        }

        return list.toArray(new String[list.size()]);

    }

    public List<String[]> getTestCases() {
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{});
        list.add(new String[]{""});
        list.add(new String[]{"Lion"});
        list.add(new String[]{"Flask"});
        list.add(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        return list;
    }
    public static void main(String[] args) {
        P500_KeyboardRow obj = new P500_KeyboardRow();
        List<String[]> testcases = obj.getTestCases();
        for(String[] words: testcases) {
            String[] res = obj.findWords(words);
            System.out.println(Arrays.asList(res));
        }

    }
}
