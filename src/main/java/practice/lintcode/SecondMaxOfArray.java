package practice.lintcode;

// 479. Second Max of Array (LintCode)
public class SecondMaxOfArray {
    public int secondMax(int[] nums) {
        // write your code here
        int m1 = Integer.MIN_VALUE, m2 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > m1) {
                m2 = m1;
                m1 = n;
            } else if (n > m2) {
                m2 = n;
            }
        }
        return m2;
    }
}

