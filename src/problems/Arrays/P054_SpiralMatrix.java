package problems.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omkar on 1/31/19.
 */
public class P054_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length==0) return res;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int x=0,y=0;
        while(rows>0 && cols>0){
            if(rows==1) {
                for(int i=0;i<cols;i++) {
                    res.add(matrix[x][y++]);
                }
                break;
            } else if(cols==1) {
                for(int i=0;i<rows;i++) {
                    res.add(matrix[x++][y]);
                }
                break;
            }
            for(int i=0;i<cols-1;i++) {
                res.add(matrix[x][y++]);
            }

            for(int i=0;i<rows-1;i++) {
                res.add(matrix[x++][y]);
            }

            for(int i=0;i<cols-1;i++) {
                res.add(matrix[x][y--]);
            }

            for(int i=0;i<rows-1;i++) {
                res.add(matrix[x--][y]);
            }
            rows -= 2;
            cols -= 2;
            x++;
            y++;

        }

        return res;
    }

    public static void main(String[] args) {
        P054_SpiralMatrix obj = new P054_SpiralMatrix();
        int[][] ip = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> ans = obj.spiralOrder(ip);
        System.out.println(ans);

    }

}
