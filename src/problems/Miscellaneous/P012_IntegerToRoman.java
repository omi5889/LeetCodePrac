package problems.Miscellaneous;

/**
 * Created by omkar on 6/15/19.
 */
public class P012_IntegerToRoman {

    public String intToRoman(int num) {
        String[] M = new String[]{"","M","MM","MMM"};
        String[] C = new String[]{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] X = new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] I = new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};

        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

    public static void main(String[] args) {
        P012_IntegerToRoman obj = new P012_IntegerToRoman();
        int num = 433;
        String res = obj.intToRoman(num);
        System.out.print("res:: "+res);
    }
}
