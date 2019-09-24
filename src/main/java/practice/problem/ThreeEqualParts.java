package practice.problem;

// 927. Three Equal Parts
public class ThreeEqualParts {
    public int[] threeEqualParts(int[] A) {
        int[] res = new int[]{-1, -1};
        int numOfOne = 0;
        for (int a : A) {
            if (a == 1)
                numOfOne++;
        }
        if (numOfOne == 0)
            return new int[]{0, 2};
        if (numOfOne % 3 != 0)
            return res;
        int len = numOfOne / 3;
        int idx0 = -1, idx1 = -1, idx2 = -1;
        numOfOne = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                numOfOne++;
                if (numOfOne == 1)
                    idx0 = i;
                else if (numOfOne == len + 1)
                    idx1 = i;
                else if (numOfOne == 2 * len + 1)
                    idx2 = i;
            }
        }
        while (idx2 < A.length) {
            if (A[idx0] == A[idx1] && A[idx1] == A[idx2]) {
                idx0++;
                idx1++;
                idx2++;
            } else {
                return res;
            }
        }
        return new int[]{idx0 - 1, idx1};
    }
}
