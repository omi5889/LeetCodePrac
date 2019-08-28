package problems.Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omkar on 3/25/19.
 */
public class P062_UniquePaths {

    public int uniquePaths(int m, int n) {
        if(m==0) return 0;
        int[][] arr = new int[m][n];

        for(int j=0; j<n; j++) arr[0][j] = 1;
        for(int i=0; i<m; i++) arr[i][0] = 1;

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }

        return arr[m-1][n-1];

    }

    private List<int[]> getTestCases() {
        List<int[]> arrList = new ArrayList<>();
        int[] t1 = {3,3};
        int[] t2 = {4,4};
        arrList.add(t1);
        arrList.add(t2);
        return arrList;
    }

    public static void main(String[] args){
        P062_UniquePaths obj = new P062_UniquePaths();
        List<int[]> testcases = obj.getTestCases();
        for(int i=0; i<testcases.size(); i++) {
            int res = obj.uniquePaths(testcases.get(i)[0],testcases.get(i)[1]);
            System.out.println(res);
        }
    }
}
