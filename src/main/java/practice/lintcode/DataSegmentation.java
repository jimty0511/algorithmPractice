package practice.lintcode;

import java.util.ArrayList;
import java.util.List;

// 956. Data Segmentation
public class DataSegmentation {
    /**
     * @param str: The input string
     * @return: The answer
     */
    public String[] dataSegmentation(String str) {
        // Write your code here
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                if (sb.length() != 0)
                    res.add(sb.toString());
                sb.setLength(0);
            } else if (c < 'a' || c > 'z') {
                if (sb.length() != 0)
                    res.add(sb.toString());
                sb.setLength(0);
                sb.append(c);
                res.add(sb.toString());
                sb.setLength(0);
            } else
                sb.append(c);
        }
        if (sb.length() != 0)
            res.add(sb.toString());
        return res.toArray(new String[res.size()]);
    }
}
