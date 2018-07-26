package practice.problem;

// 832. Flipping an Image
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int c = A[0].length;
        for (int[] row : A) {
            for (int i = 0; i < (c + 1) / 2; i++) {
                int tmp = row[i] ^ 1;
                row[i] = row[c - 1 - i] ^ 1;
                row[c - 1 - i] = tmp;
            }
        }
        return A;
    }
}
