package practice.lintcode;

// 723. Rotate Bits - Left
public class RotateBitsLeft {
    public int leftRotate(int n, int d) {
        // write code here
        return (n << d) | (n >>> (32 - d));
    }
}
