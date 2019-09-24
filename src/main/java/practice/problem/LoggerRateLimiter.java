package practice.problem;

import java.util.*;

// 359. Logger Rate Limiter
public class LoggerRateLimiter {
    private Map<String, Integer> map;
    int lastSecond = 0;

    /**
     * Initialize your data structure here.
     */
//    public LoggerRateLimiter() {
//        map = new LinkedHashMap<String, Integer>(100, 0.6f, true) {
//            @Override
//            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
//                return lastSecond - eldest.getValue() > 10;
//            }
//        };
//    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        lastSecond = timestamp;
        if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }

    class Log {
        int timestamp;
        String message;

        public Log(int aTimestamp, String aMessage) {
            timestamp = aTimestamp;
            message = aMessage;
        }
    }

    PriorityQueue<Log> pq;
    Set<String> messages;

    public LoggerRateLimiter() {
        pq = new PriorityQueue<>(10, (a, b) -> a.timestamp - b.timestamp);
        messages = new HashSet<>();
    }

    public boolean shouldPrintMessageTwo(int timestamp, String message) {
        while (pq.size() > 0) {
            Log log = pq.peek();
            if (timestamp - log.timestamp >= 10) {
                pq.poll();
                messages.remove(log.message);
            } else
                break;
        }
        boolean res = !messages.contains(message);
        if (res) {
            pq.offer(new Log(timestamp, message));
            messages.add(message);
        }
        return res;
    }
}
