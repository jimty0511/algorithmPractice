package practice.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 339. Nested List Weight Sum
public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0)
            return 0;
        int sum = 0, level = 1;
        Queue<NestedInteger> q = new LinkedList<>();
        q.addAll(nestedList);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                NestedInteger cur = q.poll();
                if (cur.isInteger())
                    sum += cur.getInteger() * level;
                else
                    q.addAll(cur.getList());
            }
            level++;
        }
        return sum;
    }
}
