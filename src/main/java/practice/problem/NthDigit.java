package practice.problem;

// 400. Nth Digit
public class NthDigit {
    public int findNthDigit(int n) {
        int length = 1;
        long count = 9;
        int start = 1;
        while (n > length * count) {
            n -= length * count;
            length += 1;
            count *= 10;
            start *= 10;
        }
        int target = start + (n - 1) / length;
        String s = Integer.toString(target);
        return Character.getNumericValue(s.charAt((n - 1) % length));
    }
}
