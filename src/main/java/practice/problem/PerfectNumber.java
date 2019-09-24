package practice.problem;

// 507. Perfect Number
public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1)
            return false;
        int sum = 0;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }
        sum++;
        return sum == num;
    }

    public boolean checkPerfectNumberTwo(int num) {
        if (num <= 1)
            return false;
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                sum += i + num / i;
        }
        sum++;
        return sum == num;
    }
}
