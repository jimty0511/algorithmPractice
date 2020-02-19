package practice.problem;

// https://leetcode.com/discuss/interview-question/366869/
public class LexicographicallySmallestString {
    public String solution(String s) {
        if (s == null || s.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder(s);
        int i;
        for (i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1))
                break;
        }
        sb.deleteCharAt(i);
        return sb.toString();
    }
}
