package practice.problem;

import java.util.ArrayList;
import java.util.List;

public class MissingWords {
    public List<String> missingWords(String s, String t) {
        if (s == null || t == null)
            return null;
        String[] strings1 = s.split(" ");
        String[] strings2 = t.split(" ");
        int m = strings1.length, n = strings2.length;
        int i = 0, j = 0;
        List<String> res = new ArrayList<>();
        while (i < m && j < n) {
            String sCurr = strings1[i];
            String tCurr = strings2[j];
            while (i < m && !sCurr.equals(tCurr)) {
                res.add(sCurr);
                sCurr = strings1[++i];
            }
            i++;
            j++;
        }
        if (i < m && j == n) {
            while (i < m) {
                res.add(strings1[i++]);
            }
        }
        return res;
    }
}
