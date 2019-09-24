package practice.problem;

// 831. Masking Personal Information
public class MaskingPersonalInformation {
    public String maskPII(String S) {
        String[] country = {"", "+*-", "+**-", "+***-"};
        int at = S.indexOf("@");
        if (at > 0) {
            S = S.toLowerCase();
            return S.charAt(0) + "*****" + S.substring(at - 1);
        }
        S = S.replaceAll("[^0-9]", "");
        return country[S.length() - 10] + "***-***-" + S.substring(S.length() - 4);
    }
}
