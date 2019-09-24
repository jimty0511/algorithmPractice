package practice.problem;

// 459. Repeated Substring Pattern
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
        for (int i = l / 2; i >= 1; i--) {
            if (l % i == 0) {
                int m = l / i;
                String subStr = s.substring(0, i);
                int j;
                for (j = 1; j < m; j++) {
                    if (!subStr.equals(s.substring(j * i, i + j * i)))
                        break;
                }
                if (j == m)
                    return true;
            }
        }
        return false;
    }
}
