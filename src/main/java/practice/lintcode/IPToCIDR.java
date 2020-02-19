package practice.lintcode;

import java.util.ArrayList;
import java.util.List;

// 852. IP to CIDR
// Airbnb ladder
public class IPToCIDR {
    /**
     * @param ip: the given start ip address
     * @param n:  the number of ips we need to cover
     * @return: a representation of the range as a list (of smallest possible length) of CIDR blocks
     */
    public List<String> ipToCIDR(String ip, int n) {
        // Write your code here
        long x = 0;
        String[] ips = ip.split("\\.");
        for (String i : ips)
            x = Integer.parseInt(i) + x * 256;
        List<String> res = new ArrayList<>();
        while (n > 0) {
            long step = x & -x;
            long stepTmp = Long.lowestOneBit(x);
            while (step > n)
                step /= 2;
            res.add(longToIp(x, (int) step));
            x += step;
            n -= step;
        }
        return res;
    }

    private String longToIp(long x, int step) {
        int[] ans = new int[4];
        ans[0] = (int) (x & 255);
        x >>= 8;
        ans[1] = (int) (x & 255);
        x >>= 8;
        ans[2] = (int) (x & 255);
        x >>= 8;
        ans[3] = (int) x;
        int len = 33;
        while (step > 0) {
            len--;
            step /= 2;
        }
        return ans[3] + "." + ans[2] + "." + ans[1] + "." + ans[0] + "/" + len;
    }
}
