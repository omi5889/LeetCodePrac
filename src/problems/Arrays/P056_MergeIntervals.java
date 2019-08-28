package problems.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by omkar on 5/15/19.
 */
public class P056_MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if(intervals.length<2) return intervals;
        List<int[]> list = new ArrayList<>();
        int rows = intervals.length;
        int cols = intervals[0].length;
        int[] start = new int[rows];
        int[] end = new int[rows];
        for(int i=0; i<rows; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }


        Arrays.sort(start);
        disp(start);
        Arrays.sort(end);
        disp(end);
        System.out.println(Arrays.asList(end));
        for(int i=0, j=0; i<rows; i++) {
            if(i==rows-1 || start[i+1] > end[i]) {
                list.add(new int[]{start[j],end[i]});
                j = i+1;
            }
        }

        int[][] res= new int[list.size()][];
        for(int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public void disp(int[] arr) {
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String[] args){

        P056_MergeIntervals obj = new P056_MergeIntervals();
        int[][] intervals = new int[][]{{1,3},{8,10},{15,18},{2,7}};
        int[][] res = obj.merge(intervals);
        for(int i=0; i<res.length; i++) {
            for(int j=0; j<res[0].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

    }
}
