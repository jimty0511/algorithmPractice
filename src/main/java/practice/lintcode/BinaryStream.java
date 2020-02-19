package practice.lintcode;

import java.util.ArrayList;
import java.util.List;

// 1570. Binary Stream
public class BinaryStream {
    /**
     * @param s: the binary stream
     * @return: the outputs
     */
    public int[] getOutput(String s) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            tmp *= 2;
            tmp += Integer.valueOf(s.charAt(i) - '0');
            tmp %= 3;
            if (tmp == 0)
                res.add(i + 1);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
