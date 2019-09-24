package practice.problem;

// 1004. Max Consecutive Ones III
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int zero = 0, start = 0, res = 0;
        for (int end = 0; end < A.length; end++) {
            if (A[end] == 0)
                zero++;
            while (zero > K) {
                if (A[start] == 0)
                    zero--;
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
