package practice.problem;

// 1051. Height Checker
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] cnt = new int[101];
        for (int h : heights)
            cnt[h]++;
        int res = 0;
        int curH = 0;
        for (int i = 0; i < heights.length; i++) {
            while (cnt[curH] == 0)
                curH++;
            if (curH != heights[i])
                res++;
            cnt[curH]--;
        }
        return res;
    }
}
