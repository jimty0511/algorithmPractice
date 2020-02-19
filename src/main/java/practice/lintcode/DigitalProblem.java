package practice.lintcode;

// 952. Digital Problem
public class DigitalProblem {
    /**
     * @param n: the number n
     * @return: the times n convert to 1
     */
    public int digitConvert(int n) {
        // Write your code here
        int cnt = 0;
        while (n != 1) {
            if (n % 2 == 1)
                n = n * 3 + 1;
            else
                n /= 2;
            cnt++;
        }
        return cnt;
    }
}
