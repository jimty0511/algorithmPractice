package practice.problem;

// 1021. Best Sightseeing Pair
public class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0, maxSoFar = A[0];
        for (int i = 1; i < A.length; i++) {
            res = Math.max(res, maxSoFar + A[i] - i);
            maxSoFar = Math.max(maxSoFar, A[i] + i);
        }
        return res;
    }

    public int maxScoreSightseeingPairTwo(int[] A) {
        int ans = 0, i = 0;
        for (int j = 1; j < A.length; j++) {
            ans = Math.max(ans, A[i] + i + A[j] - j);
            if (A[i] + i < A[j] + j)
                i = j;
        }
        return ans;
    }
}
