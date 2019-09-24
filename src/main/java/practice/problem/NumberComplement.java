package practice.problem;

// 476. Number Complement
public class NumberComplement {
    public int findComplement(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return ~num & mask;
    }

    public int findComplementTwo(int num) {
        int n = 0;
        while (n < num) {
            n = (n << 1) | 1;
        }
        return n - num;
    }

    public int findComplementThree(int num) {
        return num ^ ((Integer.highestOneBit(num) << 1) - 1);
    }
}
