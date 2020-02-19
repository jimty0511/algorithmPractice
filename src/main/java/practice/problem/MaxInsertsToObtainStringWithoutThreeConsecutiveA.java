package practice.problem;

// https://leetcode.com/discuss/interview-question/398056/
public class MaxInsertsToObtainStringWithoutThreeConsecutiveA {
    public int solution(String s) {
        if (s == null || s.length() == 0)
            return 2;
        int res = 0;
        char c = s.charAt(0);
        int cntOfA = c == 'a' ? 1 : 0;
        res += c == 'a' ? 0 : 2;
        for (int i = 1; i <= s.length(); i++) {
            if (i == s.length()) {
                res += 2 - cntOfA;
                break;
            }
            c = s.charAt(i);
            if (c != 'a') {
                res += 2 - cntOfA;
                cntOfA = 0;
            } else {
                cntOfA++;
            }
            if (cntOfA >= 3)
                return -1;
        }
        return res;
    }
}
