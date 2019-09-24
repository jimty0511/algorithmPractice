package practice.problem;

// 832. Flipping an Image
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int c = A[0].length;
        for (int[] row : A) {
            int low = 0, high = c - 1;
            while (low <= high) {
                if (row[low] == row[high]) {
                    row[low] = row[high] ^= 1;
                }
                low++;
                high--;
            }
        }
        return A;
    }
}
