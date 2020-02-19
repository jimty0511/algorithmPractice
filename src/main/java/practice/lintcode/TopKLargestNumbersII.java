package practice.lintcode;

import java.util.*;

// 545. Top k Largest Numbers II
public class TopKLargestNumbersII {

    private int size;
    private PriorityQueue<Integer> pq;

    /*
     * @param k: An integer
     */
    public TopKLargestNumbersII(int k) {
        // do intialization if necessary
        size = k;
        pq = new PriorityQueue<>();
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        if (pq.size() < size) {
            pq.offer(num);
            return;
        }
        if (num > pq.peek()) {
            pq.poll();
            pq.offer(num);
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        List<Integer> res = new ArrayList<>();
        Iterator<Integer> it = pq.iterator();
        while (it.hasNext())
            res.add(it.next());
        Collections.sort(res, Collections.reverseOrder());
        return res;
    }
}
