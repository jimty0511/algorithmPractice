package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 93. Restore IP Addresses
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12)
            return result;
        helper(s, result, 0, "", 0);
        return result;
    }

    private void helper(String ip, List<String> result, int idx, String stored, int count) {
        if (count > 4)
            return;
        if (count == 4 && idx == ip.length())
            result.add(stored);
        for (int i = 1; i < 4; i++) {
            if (idx + i > ip.length())
                break;
            String s = ip.substring(idx, idx + i);
            if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) > 255))
                continue;
            helper(ip, result, idx + i, stored + s + (count == 3 ? "" : "."), count + 1);
        }
    }
}
