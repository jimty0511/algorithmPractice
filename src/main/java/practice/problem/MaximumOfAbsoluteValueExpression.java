package practice.problem;

// 1131. Maximum of Absolute Value Expression
public class MaximumOfAbsoluteValueExpression {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int n = arr1.length, res = 0;
        int maxmm = Integer.MIN_VALUE / 2, maxmp = Integer.MIN_VALUE / 2,
                maxpm = Integer.MIN_VALUE / 2, maxpp = Integer.MIN_VALUE / 2;
        for (int i = 0; i < n; i++) {
            maxmm = Math.max(maxmm, -arr1[i] - arr2[i] - i);
            maxmp = Math.max(maxmp, -arr1[i] + arr2[i] - i);
            maxpm = Math.max(maxpm, arr1[i] - arr2[i] - i);
            maxpp = Math.max(maxpp, arr1[i] + arr2[i] - i);
            res = Math.max(res, maxmm + arr1[i] + arr2[i] + i);
            res = Math.max(res, maxmp + arr1[i] - arr2[i] + i);
            res = Math.max(res, maxpm - arr1[i] + arr2[i] + i);
            res = Math.max(res, maxpp - arr1[i] - arr2[i] + i);
        }
        return res;
    }
}
