package practice.problem;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 973. K Closest Points to Origin
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K-- > 0) {
            res[K] = pq.poll();
        }
        return res;
    }

    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                int diff = distance(p2, origin) - distance(p1, origin);
                if (diff == 0)
                    diff = p2.x - p1.x;
                if (diff == 0)
                    diff = p2.y - p1.y;
                return diff;
            }
        });
        for (Point p : points) {
            pq.offer(p);
            if (pq.size() > k)
                pq.poll();
        }
        Point[] res = new Point[k];
        while (k-- > 0) {
            res[k] = pq.poll();
        }
        return res;
    }

    private int distance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    public int[][] kClosestQuickSelect(int[][] points, int K) {
        qsHelper(points, 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void qsHelper(int[][] points, int lo, int hi, int K) {
        while (lo < hi) {
            int pivot = qsDis(points[lo]);
            int i = lo + 1;
            int j = hi;
            while (i <= j) {
                while (i <= hi && qsDis(points[i]) <= pivot)
                    i++;
                while (j > lo && qsDis(points[j]) >= pivot)
                    j--;
                if (i < j)
                    swap(points, i, j);
            }
            swap(points, lo, j);
            if (j == K - 1)
                break;
            else if (j > K - 1)
                hi = j - 1;
            else
                lo = j + 1;
        }
    }

    private int qsDis(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    private void swap(int[][] points, int x, int y) {
        int t1 = points[x][0], t2 = points[x][1];
        points[x][0] = points[y][0];
        points[x][1] = points[y][1];
        points[y][0] = t1;
        points[y][1] = t2;
    }

    public int[][] kClosestQuickSelectTwo(int[][] points, int K) {
        int start = 0, end = points.length - 1;
        while (start < end) {
            int pivot = quickSelect(points, start, end);
            if (pivot < K)
                start = pivot + 1;
            else if (pivot > K)
                end = pivot - 1;
            else
                break;
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int quickSelect(int[][] points, int start, int end) {
        int pivot = start;
        while (start <= end) {
            while (start <= end && qsDis(points[start]) <= qsDis(points[pivot]))
                start++;
            while (start <= end && qsDis(points[end]) > qsDis(points[pivot]))
                end--;
            if (start > end)
                break;
            swap(points, start, end);
        }
        swap(points, pivot, end);
        return end;
    }
}
