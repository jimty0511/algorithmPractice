package practice.problem;

// 396. Rotate Function
public class RotateFunction {
    /**
     * F(0) = (0A) + (1B) + (2C) + (3D) + (4E)
     * F(1) = (4A) + (0B) + (1C) + (2D) + (3E)
     * F(2) = (3A) + (4B) + (0C) + (1D) + (2*E)
     * <p>
     * 1. F(0) - sum =>
     * F(0) = (-1A) + (0B) + (1C) + (2D) + (3*E)
     * 2. F(1) = F(0) + 5A
     * F(1) = (4A) + (0B) + (1C) + (2D) + (3E)
     *
     * @param A
     * @return
     */
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int sum = 0, iteration = 0, len = A.length;
        for (int i = 0; i < len; i++) {
            sum += A[i];
            iteration += A[i] * i;
        }
        int max = iteration;
        for (int j = 1; j < len; j++) {
            iteration = iteration - sum + A[j - 1] * len;
            max = Math.max(max, iteration);
        }
        return max;
    }
}
