package practice.problem;

// 482. License Key Formatting
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                sb.append(count == K ? "-" : "");
                count = count == K ? 1 : count + 1;
                sb.append(Character.isDigit(S.charAt(i)) ? S.charAt(i) : Character.toUpperCase(S.charAt(i)));
            }
        }
        return sb.reverse().toString();
    }
}
