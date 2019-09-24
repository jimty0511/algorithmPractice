package practice.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 170. Two Sum III - Data structure design
public class TwoSumIII {

    Set<Integer> sum;
    Set<Integer> num;

    /**
     * Initialize your data structure here.
     */
    public TwoSumIII() {
        sum = new HashSet<>();
        num = new HashSet<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        if (num.contains(number)) {
            sum.add(number * 2);
        } else {
            Iterator<Integer> iterator = num.iterator();
            while (iterator.hasNext()) {
                sum.add(iterator.next() + number);
            }
            num.add(number);
        }
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        return sum.contains(value);
    }
}
