package problems.Arrays;

/**
 * Created by omkar on 5/3/19.
 *
 * https://leetcode.com/problems/island-perimeter/discuss/95122/Clean-java-solution-O(mn)
 */
public class P463_IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int[][] d = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int per = 0, x = 0, y = 0;

        for(int i=0; i< grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) {

                    for(int k=0; k<d.length; k++) {
                        x = i+d[k][0];
                        y = j+d[k][1];
                        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]==0) {
                            per++;
                        }
                    }

                }
            }
        }
        return per;
    }
    public static void main(String[] args) {
        P463_IslandPerimeter obj = new P463_IslandPerimeter();
        int[][] grid = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int res = obj.islandPerimeter(grid);
        System.out.println(res);
    }
}
