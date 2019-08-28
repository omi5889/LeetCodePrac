package problems.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omkar on 3/18/19.
 */
public class P043_MultiplyStrings {
    /*
    * by lx223
      https://leetcode.com/problems/multiply-strings/discuss/17608/AC-solution-in-Java-with-explanation
    * */
    public String multiply2(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();

    }

    public String multiply(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        String n1 = reverseNum(num1);
        String n2 = reverseNum(num2);
        int l1 = num1.length();
        int l2 = num2.length();
        int[] resarr = new int[l1+l2];

        if(num1.length()==1 && num1.charAt(0)-'0'==0) return "0";
        if(num2.length()==1 && num2.charAt(0)-'0'==0) return "0";

        if(num1.length()==1 && num1.charAt(0)-'0'==1 && num2.length()>1) return num2;
        if(num2.length()==1 && num2.charAt(0)-'0'==1 && num1.length()>1) return num1;


        int nc = 0;

        StringBuilder temp = new StringBuilder();
        for(int i=0; i<l1; i++) {
            for(int k=0;k<i;k++)
                temp.append("0");
            for (int j = 0; j < l2; j++) {
                int carry = nc;
                nc = 0;
                int prod = (n1.charAt(i) - '0') * (n2.charAt(j) - '0') + carry;
                if(j!=l2-1) {
                    temp.append(prod%10);
                    nc = prod/10;
                } else if(j==l2-1 && prod>9){
                    temp.append(prod%10);
                    temp.append(prod/10);
                } else if(j==l2-1 && prod<=9) {
                    temp.append(prod);
                }
            }

            for(int p=0; p<temp.toString().length(); p++) {
                resarr[p] += temp.toString().charAt(p)-'0';
                if(resarr[p]>9) {
                    resarr[p+1] += resarr[p]/10;
                    resarr[p] = resarr[p] %10;
                }
            }
            temp.setLength(0);

        }

        int cnt = 0;
        for(int i= (resarr.length)-1; i >=0; i--){
            if(resarr[i]!=0) {
                cnt = i;
                break;
            }
        }
        while(cnt>=0) {
            sb.append(resarr[cnt]);
            cnt--;
        }

        for(int num: resarr) System.out.print(num);
        return sb.toString();
    }

    private String reverseNum(String num) {
        if(num==null||num.equalsIgnoreCase("")) return num;
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        sb = sb.reverse();
        return sb.toString();
    }

    private List<String[]> getTestcases() {
        List<String[]> strList = new ArrayList<>();
//        strList.add(new String[]{"0","999"});
//        strList.add(new String[]{"355","1"});
//        strList.add(new String[]{"100","16"});
//        strList.add(new String[]{"20","2244"});
//        strList.add(new String[]{"2342451","928493"});
//        strList.add(new String[]{"123","456"});
//        strList.add(new String[]{"999","999"});
        strList.add(new String[]{"78","89"});
        return strList;
    }

    public static void main(String[] args){
        P043_MultiplyStrings obj = new P043_MultiplyStrings();
        List<String[]> testcases = obj.getTestcases();
        for(String[] iparr: testcases) {
            String res = obj.multiply2(iparr[0],iparr[1]);
            System.out.println("  res:: "+res);
        }

    }
}
