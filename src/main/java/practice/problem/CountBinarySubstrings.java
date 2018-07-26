package practice.problem;

// 696. Count Binary Substrings
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int pre = 0, cur = 1, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) {
                res++;
            }
        }
        return res;
    }
}
