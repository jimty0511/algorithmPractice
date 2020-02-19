package practice.problem;

import java.util.*;

// 210. Course Schedule II
// Microsoft ladder
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

    public int[] findOrderTwo(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            res[visited++] = pre;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == pre) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) {
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        return visited == numCourses ? res : new int[0];
    }
}
