package problems.Strings;

/**
 * Created by omkar on 6/5/19.
 *
 *
 *
 *https://leetcode.com/problems/dota2-senate/discuss/244922/Java-beats-100-no-need-for-any-algorithm....
 *
 */
public class P649_Dota2Senate {

    public String predictPartyVictory(String senate) {
        if(senate==null) return null;
        if(senate.equalsIgnoreCase("")) return "Dire";
        int rcnt = 0, dcnt = 0, rskip = 0, dskip = 0;
        char[] carr = senate.toCharArray();
        for(int i=0; i<carr.length; i++) {
            if(carr[i]=='R') rcnt++;
            else dcnt++;
        }

        while(true) {
            for(int i=0; i<carr.length; i++) {
                if(carr[i]=='X') continue;
                if(carr[i]=='R') {
                    if(rskip>0) {
                        carr[i] = 'X';
                        rskip--;
                        rcnt--;
                    } else {
                        dskip++;
                    }
                } else {
                    if(dskip>0) {
                        carr[i] = 'X';
                        dskip--;
                        dcnt--;
                    } else {
                        rskip++;
                    }
                }
            }

            if(dcnt<=0) return "Radiant";
            if(rcnt<=0) return "Dire";
        }


    }

    public static void main(String[] args) {
        P649_Dota2Senate obj = new P649_Dota2Senate();
        String[] arr = new String[]{"","R","DDR"};
        for(int i=0; i<arr.length; i++) {
            String res = obj.predictPartyVictory(arr[i]);
            System.out.println("res:: "+res);
        }
    }
}
