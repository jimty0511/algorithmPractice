package practice.lintcode;

import java.util.ArrayList;
import java.util.List;

// 426. Restore IP Addresses
// Microsoft Ladder
public class RestoreIPAddress {
    /**
     * @param s: the IP string
     * @return: All possible valid IP addresses
     */
    public List<String> restoreIpAddresses(String s) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12)
            return res;
        helper(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void helper(List<String> res, List<String> tmp, String s, int idx) {
        if (tmp.size() == 4) {
            if (idx != s.length())
                return;
            StringBuilder sb = new StringBuilder();
            for (String t : tmp) {
                sb.append(t).append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        for (int i = idx; i < s.length() && i < idx + 3; i++) {
            String sub = s.substring(idx, i + 1);
            if (isValid(sub)) {
                tmp.add(sub);
                helper(res, tmp, s, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0')
            return s.equals("0");
        int num = Integer.valueOf(s);
        return num >= 0 && num <= 255;
    }
}
