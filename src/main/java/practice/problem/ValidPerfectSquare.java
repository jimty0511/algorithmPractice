package practice.problem;

// 367. Valid Perfect Square
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long low = 1, high = num / 2, mid = 0;
        long n = (long) num;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mid * mid == n)
                return true;
            else if (mid * mid < n)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}
