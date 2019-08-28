package problems.Arrays;

import java.util.*;

/**
 * Created by omkar on 4/8/19.
 */
public class P973_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {

        Map<Integer,List<int[]>> tmap = new TreeMap<>();
        for(int[] point: points) {
            int distance = point[0]*point[0] + point[1]*point[1];
            if(!tmap.containsKey(distance))
                tmap.put(distance, new ArrayList<int[]>());
            tmap.get(distance).add(point);
        }

        for(int min: tmap.keySet()) {
            if(K>0) {
                int[][] arr = new int[tmap.get(min).size()][];
                for(int i=0; i<tmap.get(min).size(); i++) {
                    arr[i] = tmap.get(min).get(i);
                }
            }
        }



//        int[][] arr = new int[tmap.get(min).size()][];
//        for(int i=0; i<tmap.get(min).size(); i++) {
//            arr[i] = tmap.get(min).get(i);
//        }
//        dispArr(arr);

        return null;
    }


//    public int[][] kClosest(int[][] points, int K) {
//        List<int[]> resList = new ArrayList<>();
//
//        Map<Integer,Integer> hmap = new HashMap<>();
//        hmap.put(0,32);
//        hmap.put(1,27);
//        hmap.put(2,15);
//        hmap.put(3,31);
//
//        List<Map.Entry<Integer,Integer>> list = new LinkedList<Map.Entry<Integer,Integer>>(hmap.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return (o1.getValue()).compareTo(o2.getValue());
//            }
//        });
//
//        Map<Integer,Integer> temp = new HashMap<>();

//        return null;
//    }

//    public List<int[][]> getTestCases() {
//        List<int[][]> list = new ArrayList<>();
//        list.add(new int[][]{{1},{1,3},{-2,2}});
//        return list;
//    }

    public void dispArr(int[][] arr) {
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        P973_KClosestPointsToOrigin obj = new P973_KClosestPointsToOrigin();
        int[][] arr = new int[][]{{3,3},{5,-1},{2,4}};
        int k = 1;
        int[][] res = obj.kClosest(arr,k);

    }
}
