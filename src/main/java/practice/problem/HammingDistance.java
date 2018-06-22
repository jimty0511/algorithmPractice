package practice.problem;

// 461. Hamming Distance
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistanceTwo(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i = 0; i < 32; i++)
            count += (xor >> i) & 1;
        return count;
    }
}
