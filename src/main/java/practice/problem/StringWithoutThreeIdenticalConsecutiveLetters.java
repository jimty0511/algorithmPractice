package practice.problem;

// https://leetcode.com/discuss/interview-question/398039/
public class StringWithoutThreeIdenticalConsecutiveLetters {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        char curr = s.charAt(0);
        for (char c : s.toCharArray()) {
            if (c == curr) {
                cnt++;
            } else {
                cnt = 1;
                curr = c;
            }
            if (cnt < 3)
                sb.append(c);
        }
        return sb.toString();
    }
}
