package practice.lintcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 541. Zigzag Iterator II
public class ZigzagIterator2 {

    Queue<Iterator<Integer>> q;

    /*
     * @param vecs: a list of 1d vectors
     */
    public ZigzagIterator2(List<List<Integer>> vecs) {
        // do intialization if necessary
        q = new LinkedList<>();
        for (List<Integer> v : vecs) {
            if (!v.isEmpty())
                q.offer(v.iterator());
        }
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
