package practice.problem;

// https://leetcode.com/discuss/interview-question/398026/
public class MinMovesToObtainStringWithoutThreeIdenticalConsecutiveLetters {
    public int solution(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int next = i + 1;
            while (next < s.length() && s.charAt(i) == s.charAt(next))
                next++;
            int dis = next - i;
            if (dis >= 3) {
                while (dis > 5) {
                    res++;
                    dis -= 3;
                }
                if (dis <= 5)
                    res++;
            }
            i = next;
        }
        return res;
    }
}
