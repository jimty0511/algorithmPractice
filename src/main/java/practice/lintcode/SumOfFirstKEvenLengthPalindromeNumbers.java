package practice.lintcode;

// 744. Sum of first K even-length Palindrome numbers
public class SumOfFirstKEvenLengthPalindromeNumbers {
    public int sumKEven(int k) {
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            String num = String.valueOf(i);
            String rev = reverse(num);
            int fullNum = Integer.valueOf(num + rev);
            sum += fullNum;
        }
        return sum;
    }

    private String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
