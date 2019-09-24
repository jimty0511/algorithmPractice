package practice.problem;

// 357. Count Numbers with Unique Digits
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int ans = 10, base = 9;
        for (int i = 2; i <= n && i <= 10; i++) {
            base = base * (9 - i + 2);
            ans += base;
        }
        return ans;
    }

    public int countNumbersWithUniqueDigitsTwo(int n) {
        if (n == 0)
            return 1;
        int res = 10;
        int uniqDigits = 9;
        int available = 9;
        while (n-- > 1 && available > 0) {
            uniqDigits = uniqDigits * available;
            res += uniqDigits;
            available--;
        }
        return res;
    }
}
