package practice.problem;

// 667. Beautiful Arrangement II
public class BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        if (k >= n)
            return null;
        int[] arr = new int[n];
        int i = 0, small = 1, large = n;
        while (i < k) {
            arr[i++] = small++;
            if (i < k) {
                arr[i++] = large--;
            }
        }
        if (k % 2 == 0) {
            while (i < arr.length)
                arr[i++] = large--;
        } else {
            while (i < arr.length)
                arr[i++] = small++;
        }
        return arr;
    }

    public int[] constructArrayTwo(int n, int k) {
        int[] res = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++) {
            res[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : l++;
        }
        return res;
    }
}
