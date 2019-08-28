package problems.Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omkar on 3/25/19.
 */
public class P063_UniquePathsII {

    private int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0) return 0;
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] arr = new int[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(obstacleGrid[i][j]==1) arr[i][j] = 0;
                else if(i==0 && j==0) arr[i][j] = 1;
                else if(i==0) arr[i][j] = arr[i][j-1] * 1;
                else if(j==0) arr[i][j] = arr[i-1][j] * 1;
                else arr[i][j] = arr[i-1][j]+arr[i][j-1];

            }
        }

        return arr[rows-1][cols-1];
    }


    private List<int[][]> getTestCases() {
        List<int[][]> arrList = new ArrayList<>();
        int[][] t1 = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] t2 = {{0,0,0},{0,0,0},{0,0,0}};
        arrList.add(t1);
        arrList.add(t2);
        return arrList;
    }

    public static void main(String[] args) {
        P063_UniquePathsII obj = new P063_UniquePathsII();
        List<int[][]> testcases = obj.getTestCases();
        for(int i=0; i<testcases.size(); i++) {
            int res = obj.uniquePathsWithObstacles(testcases.get(i));
            System.out.println(res);
        }
    }

}
