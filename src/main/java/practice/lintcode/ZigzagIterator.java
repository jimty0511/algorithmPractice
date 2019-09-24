package practice.lintcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 540. Zigzag Iterator
public class ZigzagIterator {

    Queue<Iterator<Integer>> q;

    /*
     * @param v1: A 1d vector
     * @param v2: A 1d vector
     */
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // do intialization if necessary
        q = new LinkedList<>();
        if (!v1.isEmpty())
            q.offer(v1.iterator());
        if (!v2.isEmpty())
            q.offer(v2.iterator());
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        hasNext();
        Iterator<Integer> iterator = q.poll();
        int val = iterator.next();
        if (iterator.hasNext())
            q.offer(iterator);
        return val;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return !q.isEmpty();
    }
}
