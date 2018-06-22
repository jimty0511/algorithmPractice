package practice.problem;

// 231. Power of Two
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
        // n>0 && (n&(n-1))==0
    }
}
