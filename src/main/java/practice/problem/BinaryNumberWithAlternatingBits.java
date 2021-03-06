package practice.problem;

// 693. Binary Number with Alternating Bits
public class BinaryNumberWithAlternatingBits {
    /*
        n =         1 0 1 0 1 0 1 0
        n >> 1      0 1 0 1 0 1 0 1
        n ^ n>>1    1 1 1 1 1 1 1 1
        n           1 1 1 1 1 1 1 1
        n + 1     1 0 0 0 0 0 0 0 0
        n & (n+1)   0 0 0 0 0 0 0 0
    */
    public boolean hasAlternatingBits(int n) {
        n = n ^ (n >> 1);
        return (n & n + 1) == 0;
    }
}
