package practice.lintcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

// 960. First Unique Number in Data Stream II
public class FirstUniqueNumberInDataStreamII {

    private Set<Integer> visited;
    private LinkedHashSet<Integer> unique;

    public FirstUniqueNumberInDataStreamII() {
        // do intialization if necessary
        visited = new HashSet<>();
        unique = new LinkedHashSet<>();
    }

    /**
     * @param num: next number in stream
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        if (visited.contains(num)) {
            unique.remove(num);
            return;
        }
        visited.add(num);
        unique.add(num);
    }

    /**
     * @return: the first unique number in stream
     */
    public int firstUnique() {
        // write your code here
        Iterator<Integer> it = unique.iterator();
        if (it.hasNext())
            return it.next();
        return -1;
    }
}
