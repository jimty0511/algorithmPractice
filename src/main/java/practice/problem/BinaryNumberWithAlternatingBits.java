package practice.problem;

// 693. Binary Number with Alternating Bits
public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        return ((n ^= n >> 1) & n + 1) == 0;
    }
}
