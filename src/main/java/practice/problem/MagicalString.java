package practice.problem;

// 481. Magical String
public class MagicalString {
    public int magicalString(int n) {
        if (n <= 0)
            return 0;
        if (n <= 3)
            return 1;
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 2;
        a[2] = 2;
        int head = 2, tail = 3, num = 1, res = 1;
        while (tail < n) {
            for (int i = 0; i < a[head]; i++) {
                a[tail] = num;
                if (num == 1 && tail < n)
                    res++;
                tail++;
            }
            num ^= 3;
            head++;
        }
        return res;
    }
}
