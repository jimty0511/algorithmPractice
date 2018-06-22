package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 320. Generalized Abbreviation
public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        helper(result, new StringBuilder(), word.toCharArray(), 0, 0);
        return result;
    }

    private void helper(List<String> result, StringBuilder sb, char[] c, int i, int num) {
        int len = sb.length();
        if (i == c.length) {
            if (num != 0)
                sb.append(num);
            result.add(sb.toString());
        } else {
            helper(result, sb, c, i + 1, num + 1);
            if (num != 0)
                sb.append(num);
            helper(result, sb.append(c[i]), c, i + 1, 0);
        }
        sb.setLength(len);
    }
}
