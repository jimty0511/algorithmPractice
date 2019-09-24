package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 788. Rotated Digits
public class RotatedDigits {
    public int rotatedDigits(int N) {
        int sum = 0;
        for (int i = 2; i <= N; i++) {
            if (helper(i))
                sum++;
        }
        return sum;
    }

    private boolean helper(int n) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('2', '5');
        map.put('5', '2');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        String ori = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for (char c : ori.toCharArray()) {
            if (map.containsKey(c)) {
                sb.append(map.get(c));
            } else {
                return false;
            }
        }
        return !sb.toString().equals(ori);
    }

    public int rotatedDigitsDp(int N) {
        int[] dp = new int[N + 1];
        int count = 0;
        for (int i = 0; i <= N; i++) {
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8)
                    dp[i] = 1;
                else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    count++;
                }
            } else {
                int a = dp[i / 10], b = dp[i % 10];
                if (a == 1 && b == 1)
                    dp[i] = 1;
                else if (a >= 1 && b >= 1) {
                    dp[i] = 2;
                    count++;
                }
            }
        }
        return count;
    }
}
