package practice.problem;

// 191. Number of 1 Bits
public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            ones = ones + (n & 1);
            n >>>= 1;
        }
        return ones;
    }

    public int hammingWeightTwo(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
