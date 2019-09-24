package practice.problem;

// 801. Minimum Swaps To Make Sequences Increasing
public class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] A, int[] B) {
        int swap = 1, fix = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) {
                swap++;
            } else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
                int temp = swap;
                swap = fix + 1;
                fix = temp;
            } else {
                int min = Math.min(swap, fix);
                swap = min + 1;
                fix = min;
            }
        }
        return Math.min(swap, fix);
    }

    public int minSwapTwo(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return 0;
        int n = A.length;
        int[] swap = new int[n], noSwap = new int[n];
        swap[0] = 1;
        noSwap[0] = 0;
        for (int i = 1; i < n; i++) {
            swap[i] = noSwap[i] = n;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                swap[i] = swap[i - 1] + 1;
                noSwap[i] = noSwap[i - 1];
            }
            if (B[i - 1] < A[i] && A[i - 1] < B[i]) {
                swap[i] = Math.min(swap[i], noSwap[i - 1] + 1);
                noSwap[i] = Math.min(noSwap[i], swap[i - 1]);
            }
        }
        return Math.min(swap[n - 1], noSwap[n - 1]);
    }

    public int minSwapThree(int[] A, int[] B) {
        int n = A.length;
        int[][] state = new int[n][2];   // state[i][0] means no swap, state[i][1] means swap
        state[0][1] = 1;
        for (int i = 1; i < n; i++) {
            boolean bothSelfIncre = A[i - 1] < A[i] && B[i - 1] < B[i];
            boolean interChangeIncre = A[i - 1] < B[i] && B[i - 1] < A[i];
            if (bothSelfIncre && interChangeIncre) {
                state[i][0] = Math.min(state[i - 1][0], state[i - 1][1]);
                state[i][1] = Math.min(state[i - 1][0], state[i - 1][1]) + 1;
            } else if (bothSelfIncre) {
                state[i][0] = state[i - 1][0];
                state[i][1] = state[i - 1][1] + 1;
            } else {
                state[i][0] = state[i - 1][1];
                state[i][1] = state[i - 1][0] + 1;
            }
        }
        return Math.min(state[n - 1][0], state[n - 1][1]);
    }
}
