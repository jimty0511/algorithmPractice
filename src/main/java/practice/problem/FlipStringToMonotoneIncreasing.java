package practice.problem;

// 926. Flip String to Monotone Increasing
public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String S) {
        if (S == null || S.length() == 0)
            return 0;
        char[] chars = S.toCharArray();
        int flipCount = 0, onesCount = 0;
        for (int i = 0; i < S.length(); i++) {
            if (chars[i] == '0') {
                if (onesCount == 0)
                    continue;
                flipCount++;
            } else {
                onesCount++;
            }
            if (flipCount > onesCount) {
                flipCount = onesCount;
            }
        }
        return flipCount;
    }

    public int minFlipsMonoIncrTwo(String S) {
        if (S == null || S.length() == 0)
            return 0;
        char[] chars = S.toCharArray();
        int ones = 0, zeroes = 0;
        for (char c : chars) {
            if (c == '0') {
                ones = Math.min(ones, zeroes) + 1;
            } else {
                ones = Math.min(ones, zeroes);
                zeroes++;
            }
        }
        return Math.min(ones, zeroes);
    }
}
