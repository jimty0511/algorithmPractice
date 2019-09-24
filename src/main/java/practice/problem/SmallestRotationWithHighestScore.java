package practice.problem;

// 798. Smallest Rotation with Highest Score
public class SmallestRotationWithHighestScore {
    public int bestRotation(int[] A) {
        int n = A.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[(i + 1) % n]++;
            a[(i + 1 - A[i] + n) % n]--;
        }
        int count = 0;
        int maxCount = -1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            count += a[i];
            if (count > maxCount) {
                res = i;
                maxCount = count;
            }
        }
        return res;
    }
}
