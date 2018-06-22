package practice.problem;

// 765. Couples Holding Hands
public class CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        int res = 0, n = row.length;
        int[] ptn = new int[n];
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            ptn[i] = i % 2 == 0 ? i + 1 : i - 1;
            pos[row[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = ptn[pos[ptn[row[i]]]]; i != j; j = ptn[pos[ptn[row[i]]]]) {
                swap(row, i, j);
                swap(pos, row[i], row[j]);
                res++;
            }
        }
        return res;
    }

    public int miniSwapsArray(int[] row) {
        int res = 0, n = row.length;
        for (int i = 0; i < n; i++) {
            for (int j = row[i]; i != j; j = row[i]) {
                swap(row, i, j);
                res++;
            }
        }
        return res;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
