package practice.problem;

public class StringsThatSatisfiesTheCondition {
    public String[] getAns(String target, String[] s) {
        boolean[] ans = new boolean[s.length];
        int count = 0;
        char[] tar = target.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (helper(s[i].toCharArray(), tar)) {
                ans[i] = true;
                count++;
            }
        }
        String[] result = new String[count];
        int idx = 0;
        for (int i = 0; i < s.length; i++) {
            if (ans[i]) {
                result[idx++] = s[i];
            }
        }
        return result;
    }

    private boolean helper(char[] source, char[] target) {
        int s = 0, t = 0;
        while (s < source.length && t < target.length) {
            if (source[s] == target[t]) {
                s++;
                t++;
            } else
                s++;
        }
        return t == target.length;
    }
}
