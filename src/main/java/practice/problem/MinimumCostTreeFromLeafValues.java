package practice.problem;

// 1130. Minimum Cost Tree From Leaf Values
public class MinimumCostTreeFromLeafValues {
    int ans = 0;

    public int mctFromLeafValues(int[] arr) {
        helper(arr, 0, arr.length - 1);
        return ans;
    }

    private int helper(int[] arr, int low, int high) {
        if (low > high)
            return 0;
        if (low == high)
            return arr[low];
        if (low + 1 == high) {
            ans += arr[low] * arr[high];
            return Math.max(arr[low], arr[high]);
        }
        int maxIdx = low;
        for (int i = low; i <= high; i++) {
            if (arr[i] > arr[maxIdx])
                maxIdx = i;
        }
        int left = helper(arr, low, maxIdx - 1);
        int right = helper(arr, maxIdx + 1, high);
        if (left != 0)
            ans += arr[maxIdx] * left;
        if (right != 0)
            ans += arr[maxIdx] * right;
        return arr[maxIdx];
    }
}
