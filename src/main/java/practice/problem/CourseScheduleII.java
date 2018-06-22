package practice.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 210. Course Schedule II
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>();
        int n = indegree.length;
        while (n-- > 0)
            adjs.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            indegree[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }
        int[] order = new int[indegree.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            int from = queue.poll();
            order[visited++] = from;
            for (int to : adjs.get(from)) {
                indegree[to]--;
                if (indegree[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        return visited == numCourses ? order : new int[0];
    }
}
