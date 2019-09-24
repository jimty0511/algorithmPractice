package practice.problem;

import java.util.*;

// 850. Rectangle Area II
public class RectangleAreaII {

    class Point {
        int x, y, val;

        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public int rectangleArea(int[][] rectangles) {
        int M = 1000000007;
        List<Point> data = new ArrayList<>();
        for (int[] r : rectangles) {
            data.add(new Point(r[0], r[1], 1));
            data.add(new Point(r[0], r[3], -1));
            data.add(new Point(r[2], r[1], -1));
            data.add(new Point(r[2], r[3], 1));
        }
        Collections.sort(data, (a, b) -> a.x == b.x ? b.y - a.y : a.x - b.x);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int preX = -1, preY = -1, result = 0;
        for (int i = 0; i < data.size(); i++) {
            Point p = data.get(i);
            map.put(p.y, map.getOrDefault(p.y, 0) + p.val);
            if (map.get(p.y) == 0)
                map.remove(p.y);
            if (i == data.size() - 1 || data.get(i + 1).x > p.x) {
                if (preX > -1) {
                    result += ((long) preY * (p.x - preX)) % M;
                    result %= M;
                }
                preY = calcY(map);
                preX = p.x;
            }
        }
        return result;
    }

    private int calcY(TreeMap<Integer, Integer> map) {
        int res = 0, pre = -1, count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pre >= 0 && count > 0)
                res += entry.getKey() - pre;
            count += entry.getValue();
            pre = entry.getKey();
        }
        return res;
    }

    public int rectangleAreaTwo(int[][] rectangles) {
        int mod = (int) 1e9 + 7;
        long res = 0;
        List<int[]> recList = new ArrayList<>();
        for (int[] rec : rectangles)
            addRectangle(recList, rec, 0);
        for (int[] rec : recList)
            res = (res + ((long) (rec[2] - rec[0]) * (long) (rec[3] - rec[1]))) % mod;
        return (int) res % mod;
    }

    private void addRectangle(List<int[]> recList, int[] cur, int start) {
        if (start >= recList.size()) {
            recList.add(cur);
            return;
        }
        int[] r = recList.get(start);
        if (cur[2] <= r[0] || cur[3] <= r[1] || cur[0] >= r[2] || cur[1] >= r[3]) {
            addRectangle(recList, cur, start + 1);
            return;
        }
        if (cur[0] < r[0])
            addRectangle(recList, new int[]{cur[0], cur[1], r[0], cur[3]}, start + 1);
        if (cur[2] > r[2])
            addRectangle(recList, new int[]{r[2], cur[1], cur[2], cur[3]}, start + 1);
        if (cur[1] < r[1])
            addRectangle(recList, new int[]{Math.max(r[0], cur[0]), cur[1], Math.min(r[2], cur[2]), r[1]}, start + 1);
        if (cur[3] > r[3])
            addRectangle(recList, new int[]{Math.max(r[0], cur[0]), r[3], Math.min(r[2], cur[2]), cur[3]}, start + 1);
    }
}
