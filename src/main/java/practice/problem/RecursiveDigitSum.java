package practice.problem;

public class RecursiveDigitSum {
    public int superDigit(String n, int k) {
        while (n.length() > 1) {
            n = n.chars().mapToLong(Character::getNumericValue).sum() * k + "";
        }
        return Integer.valueOf(n);
    }
}
