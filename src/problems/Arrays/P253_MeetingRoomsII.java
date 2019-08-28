package problems.Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by omkar on 5/16/19.
 */
public class P253_MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length<2) return intervals.length;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int endIndex = 0, rooms = 0;
        for(int i=0; i<intervals.length; i++) {
            if(start[i] < end[endIndex])
                rooms++;
            else
                endIndex++;
        }
        return rooms;

//        PriorityQueue<int[]> queue2 = new PriorityQueue(new Comparator<int[]>() {
//            public int compare(int[] arr1, int[] arr2) {
//                return arr1[0] - arr2[0];
//            }
//        });
//
//        for(int i=0; i<intervals.length; i++) {
//            queue2.offer(intervals[i]);
//        }
//
//        while(!queue2.isEmpty()) {
//            int[] temp = queue2.poll();
//            System.out.println(temp[0]+" "+temp[1]);
//        }
//
//
//        return 0;
    }

    public static void main(String[] args){
        P253_MeetingRoomsII obj = new P253_MeetingRoomsII();
        int[][] intervals = new int[][]{{1,3},{8,10},{15,18},{2,7}};
        int res = obj.minMeetingRooms(intervals);
        System.out.println(res);
    }
}
