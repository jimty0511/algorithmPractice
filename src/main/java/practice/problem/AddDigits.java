package practice.problem;

// 258. Add Digits
public class AddDigits {
    public int addDigits(int num) {
        int cur = num;
        int sum = 0;
        while (true) {
            while (cur / 10 != 0) {
                sum += cur % 10;
                cur /= 10;
            }
            sum += cur;
            if (sum / 10 == 0)
                return sum;
            else {
                cur = sum;
                sum = 0;
            }
        }
    }
}
