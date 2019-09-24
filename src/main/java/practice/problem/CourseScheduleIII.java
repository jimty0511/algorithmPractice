package practice.problem;

import java.util.Arrays;
import java.util.PriorityQueue;

// 630. Course Schedule III
public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        if (courses == null || courses.length == 0 || courses[0].length == 0)
            return 0;
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] c : courses) {
            time += c[0];
            pq.add(c[0]);
            if (time > c[1])
                time -= pq.poll();
        }
        return pq.size();
    }
}
