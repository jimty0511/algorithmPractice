package practice.lcdesign;

import java.util.LinkedList;

// 505. Web Logger
// Chapter 3
public class WebLogger {

    private LinkedList<Integer> list;

    public WebLogger() {
        // do intialization if necessary
        list = new LinkedList<>();
    }

    /*
     * @param timestamp: An integer
     * @return: nothing
     */
    public void hit(int timestamp) {
        // write your code here
        list.add(timestamp);
    }

    /*
     * @param timestamp: An integer
     * @return: An integer
     */
    public int get_hit_count_in_last_5_minutes(int timestamp) {
        // write your code here
        while (!list.isEmpty() && list.peekFirst() + 300 <= timestamp)
            list.removeFirst();
        return list.size();
    }
}
