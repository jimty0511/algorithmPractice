package practice.lcdesign;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 1786. Pub Sub Pattern
// Chapter 6
public class PubSubPattern {

    static class PushNotification {
        public static void notify(int user_id, String the_message) {
        }
    }

    Map<String, Set<Integer>> map;

    public PubSubPattern() {
        // Write your code here
        map = new HashMap<>();
    }

    /**
     * @param channel: the channel's name
     * @param user_id: the user who subscribes the channel
     * @return: nothing
     */
    public void subscribe(String channel, int user_id) {
        // Write your code here
        if (!map.containsKey(channel))
            map.put(channel, new HashSet<>());
        Set<Integer> set = map.get(channel);
        set.add(user_id);
    }

    /**
     * @param channel: the channel's name
     * @param user_id: the user who unsubscribes the channel
     * @return: nothing
     */
    public void unsubscribe(String channel, int user_id) {
        // Write your code here
        if (!map.containsKey(channel))
            return;
        map.get(channel).remove(user_id);
    }

    /**
     * @param channel: the channel's name
     * @param message: the message need to be delivered to the channel's subscribers
     * @return: nothing
     */
    public void publish(String channel, String message) {
        // Write your code here
        if (!map.containsKey(channel))
            return;
        for (int userId : map.get(channel))
            PushNotification.notify(userId, message);
    }
}
