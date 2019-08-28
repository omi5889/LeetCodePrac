package problems.Miscellaneous;

/**
 * Created by omkar on 6/15/19.
 */
public class P013_RomanToInteger {

    public int romanToInt(String s) {

        if(s==null || s.trim().length()==0) return 0;
        s = s.trim();

        int sum = 0;
        char[] carr = s.toCharArray();

        for(int i=0; i<carr.length-1; i++) {
            int curr = getValue(carr[i]);
            int next = getValue(carr[i+1]);

            if(curr>=next) {
                sum += curr;
            } else {
                sum -= curr;
            }
        }

        sum += getValue(carr[carr.length-1]);

        return sum;
    }

    public int getValue(char c) {
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        P013_RomanToInteger obj = new P013_RomanToInteger();
        String s = "LVIII";
        int res = obj.romanToInt(s);
        System.out.print("res: "+res);

    }
}
