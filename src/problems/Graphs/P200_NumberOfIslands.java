package problems.Graphs;

/**
 * Created by omkar on 12/17/18.
 *
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 *
 * https://leetcode.com/problems/number-of-islands/discuss/56338/Java-DFS-and-BFS-solution
 */
public class P200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0|| grid[0].length==0) return 0;
        int count = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]=='1') {
                    islands(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void islands(char[][] grid, int i,int j){
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]=='1') {
            grid[i][j] = '0';
            islands(grid,i+1,j);
            islands(grid,i-1,j);
            islands(grid,i,j+1);
            islands(grid,i,j-1);
        }

    }

    public static void main(String[] args){
        P200_NumberOfIslands obj = new P200_NumberOfIslands();
        char[][] ip = {};
        int res = obj.numIslands(ip);
        System.out.print(res);
    }
}
