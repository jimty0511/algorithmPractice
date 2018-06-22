package practice.problem;

// 338. Counting Bits
public class CountBits {
    // f[i] = f[i / 2] + i % 2
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            int x = i >> 1;
            int a = f[x];
            int b = i & 1;
            f[i] = a + b;
        }
        return f;
    }

    public int[] countBitsDp(int num) {
        int result[] = new int[num + 1];
        int offSet = 1;
        for (int index = 1; index < num + 1; index++) {
            if (offSet * 2 == index)
                offSet *= 2;
            result[index] = result[index - offSet] + 1;
        }
        return result;
    }
}
