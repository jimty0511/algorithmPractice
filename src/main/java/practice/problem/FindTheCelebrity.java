package practice.problem;

// 277/645. Find the Celebrity
public class FindTheCelebrity {

    int[][] relation;

    public int findCelebrity(int n) {
        // Write your code here
        if (n <= 0)
            return -1;
        if (n == 1)
            return 0;
        int candi = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candi, i))
                candi = i;
        }
        for (int i = 0; i < n; i++) {
            if (candi != i && !knows(i, candi))
                return -1;
            if (candi != i && knows(candi, i))
                return -1;
        }
        return candi;
    }

    private boolean knows(int a, int b) {
        for (int[] r : relation) {
            if (r[0] == a && r[1] == b)
                return true;
        }
        return false;
    }
}
