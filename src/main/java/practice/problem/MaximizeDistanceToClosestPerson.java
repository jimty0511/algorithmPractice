package practice.problem;

// 849. Maximize Distance to Closest Person
public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int dis = Integer.MIN_VALUE;
        int n = seats.length;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                int j = i;
                while (j < n && seats[j] == 0)
                    j++;
                int diff = 0;
                if (i == 0 || j == n)
                    diff = j - i;
                else
                    diff = (j - i + 1) / 2;
                dis = Math.max(dis, diff);
                i = j;
            }
        }
        return dis;
    }

    public int maxDistToClosestTwo(int[] seats) {
        int i, j, res = 0, n = seats.length;
        for (i = j = 0; j < n; j++) {
            if (seats[j] == 1) {
                if (i == 0)
                    res = Math.max(res, j - i);
                else
                    res = Math.max(res, (j - i + 1) / 2);
                i = j + 1;
            }
        }
        res = Math.max(res, n - i);
        return res;
    }
}
