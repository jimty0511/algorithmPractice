package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 1023. Camelcase Matching
public class CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        char[] pc = pattern.toCharArray();
        for (String q : queries) {
            res.add(helper(q.toCharArray(), pc));
        }
        return res;
    }

    private boolean helper(char[] qc, char[] pc) {
        int j = 0;
        for (int i = 0; i < qc.length; i++) {
            if (j < pc.length && qc[i] == pc[j])
                j++;
            else if (Character.isUpperCase(qc[i]))
                return false;
        }
        return j == pc.length;
    }
}
