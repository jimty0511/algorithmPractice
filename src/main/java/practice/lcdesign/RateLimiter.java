package practice.lcdesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 215. Rate Limiter
// Chapter 3
public class RateLimiter {

    private Map<String, List<Integer>> map = new HashMap<>();

    /*
     * @param timestamp: the current timestamp
     * @param event: the string to distinct different event
     * @param rate: the format is [integer]/[s/m/h/d]
     * @param increment: whether we should increase the counter
     * @return: true or false to indicate the event is limited or not
     */
    public boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {
        // write your code here
        int idx = rate.indexOf("/");
        int limit = Integer.parseInt(rate.substring(0, idx));
        String type = rate.substring(idx + 1);
        int duration = 1;
        if (type.equals("m"))
            duration = duration * 60;
        else if (type.equals("h"))
            duration = duration * 60 * 60;
        else if (type.equals("d"))
            duration = duration * 60 * 60 * 24;
        int start = timestamp - duration + 1;
        map.putIfAbsent(event, new ArrayList<>());
        int cnt = getCountLargerThanStart(map.get(event), start);
        boolean isLimited = cnt >= limit;
        if (increment && !isLimited)
            map.get(event).add(timestamp);
        return isLimited;
    }

    private int getCountLargerThanStart(List<Integer> event, int start) {
        int l = 0, r = event.size() - 1;
        if (r == -1)
            return 0;
        if (event.get(r) < start)
            return 0;
//        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (event.get(mid) >= start) {
//                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return event.size() - l;
    }
}
