package practice.problem;

// 995. Minimum Number of K Consecutive Bit Flips
public class MinimumNumberOfKConsecutiveBitFlips {
    public int minKBitFlips(int[] A, int K) {
        int n = A.length, flipped = 0, res = 0;
        int[] isFlipped = new int[n];
        for (int i = 0; i < A.length; i++) {
            if (i >= K) {
                flipped ^= isFlipped[i - K];
            }
            if (flipped == A[i]) {
                if (i + K > A.length)
                    return -1;
                isFlipped[i] = 1;
                flipped ^= 1;
                res++;
            }
        }
        return res;
    }

    public int minKBitFlipsTwo(int[] A, int K) {
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                if (i + K > A.length)
                    return -1;
                flip(A, K, i);
                cnt++;
            }
        }
        return cnt;
    }

    private void flip(int[] A, int K, int i) {
        for (int j = i; j < i + K; j++)
            A[j] ^= 1;
    }
}
