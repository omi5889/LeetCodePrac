package problems.Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by omkar on 4/26/19.
 *
 *
 *
 * https://leetcode.com/problems/course-schedule/discuss/58516/Easy-BFS-Topological-sort-Java
 */
public class P207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];

        // degree is used to store the number of courses dependant on course i
        int[] degree = new int[numCourses];

        // queue used to manage the courses
        Queue queue = new LinkedList();
        int count=0;

        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        for(int i=0; i<prerequisites.length;i++){
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        // adding to queue all courses which do not depend on any other course ie degree = 0
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
                count++;
            }
        }

        // if queue is empty it means all the courses are dependent on some other course forming a closed loop
        // so it is not valid


        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if(count == numCourses)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        P207_CourseSchedule obj = new P207_CourseSchedule();
        boolean res = obj.canFinish(3, new int[][]{{1,0},{2,1}});
        System.out.println(res);
    }
}
