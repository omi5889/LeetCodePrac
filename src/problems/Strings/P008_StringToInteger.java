package problems.Strings;

/**
 * Created by omkar on 6/12/19.
 */
public class P008_StringToInteger {

    public int myAtoi(String str) {
        if(str==null || str.isEmpty()) return 0;
        str = str.trim();
        if(str.equals("")) return 0;
        if(str.length()==1 && (str.equals("+")|| str.equals("-"))) return 0;

        long res = 0;
        int mul=0, begin=0;

        if(str.charAt(0)=='+') mul = 1;
        else if(str.charAt(0)=='-') mul = -1;

        begin = mul==0 ? 0 : 1;
        if(mul==0) mul = 1;


        for(int i=begin; i<str.length(); i++) {
            char start = str.charAt(i);
            if(!Character.isDigit(start))
                return (int) res * mul;

            res = res*10 + Character.getNumericValue(start);
            if(mul==1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(mul==-1 && res*mul < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) res*mul;


    }

    public static void main(String[] args) {
        P008_StringToInteger obj = new P008_StringToInteger();
//        String str = "  -0012a42";
//        String str = "@";
        String str = "-91283472332";
        int res = obj.myAtoi(str);
        System.out.print("res:: "+res);

//        int m = Integer.MAX_VALUE;
//        System.out.println("res1:: "+m);
////        m = m+10;
//        if(m+10 > Integer.MAX_VALUE) m = Integer.MAX_VALUE;
//        System.out.println("res1:: "+m);

    }
}
