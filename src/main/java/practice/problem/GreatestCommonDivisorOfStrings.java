package practice.problem;

// 1071. Greatest Common Divisor of Strings
public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        int i = 1, max = 0, len1 = str1.length(), len2 = str2.length();
        while (i <= len1 && i <= len2 && str1.charAt(i - 1) == str2.charAt(i - 1)) {
            boolean cd = true;
            if (len1 % i == 0 && len2 % i == 0) {
                String common = str1.substring(0, i);
                for (int j = i * 2; cd && j <= len1; j += i)
                    cd = common.equals(str1.substring(j - i, j));
                for (int j = i * 2; cd && j <= len2; j += i)
                    cd = common.equals(str2.substring(j - i, j));
                if (cd)
                    max = i;
            }
            i++;
        }
        return str1.substring(0, max);
    }
}
