package practice.lintcode;

// 179. Update Bits
public class UpdateBits {
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        for (int k = i; k <= j; k++) {
            if ((n >> k & 1) != (m >> (k - i) & 1))
                n ^= 1 << k;
        }
        return n;
    }
}
