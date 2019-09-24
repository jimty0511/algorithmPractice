package practice.problem;

import java.util.Arrays;

// 869. Reordered Power of 2
public class ReorderedPowerOf2 {
//    public boolean reorderedPowerOf2(int N) {
//        long c = counter(N);
//        for (int i = 0; i < 32; i++) {
//            if (counter(1 << i) == c)
//                return true;
//        }
//        return false;
//    }
//
//    private long counter(int N) {
//        long res = 0;
//        for (; N > 0; N /= 10)
//            res += Math.pow(10, N % 10);
//        return res;
//    }

    public boolean reorderedPowerOf2Two(int N) {
        char[] a1 = String.valueOf(N).toCharArray();
        Arrays.sort(a1);
        String s1 = new String(a1);
        for (int i = 0; i < 31; i++) {
            char[] a2 = String.valueOf(1 << i).toCharArray();
            Arrays.sort(a2);
            String s2 = new String(a2);
            if (s1.equals(s2))
                return true;
        }
        return false;
    }
}
