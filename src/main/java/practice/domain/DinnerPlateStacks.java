package practice.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 1172. Dinner Plate Stacks
public class DinnerPlateStacks {

    Map<Integer, Stack<Integer>> map;
    int cap;
    int curr;
    int last;
    int totalElement;

    public DinnerPlateStacks(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        curr = 0;
        last = 0;
        totalElement = 0;
        map.put(curr, new Stack<>());
    }

    public void push(int val) {
        while (map.containsKey(curr) && map.get(curr).size() == cap)
            curr++;
        if (!map.containsKey(curr))
            map.put(curr, new Stack<>());
        map.get(curr).push(val);
        last = Math.max(last, curr);
        totalElement++;
    }

    public int pop() {
        if (totalElement == 0)
            return -1;
        while (last >= 0 && map.get(last).isEmpty())
            last--;
        totalElement--;
        curr = Math.min(curr, last);
        return map.get(last).pop();
    }

    public int popAtStack(int index) {
        if (!map.containsKey(index) || map.get(index).isEmpty())
            return -1;
        totalElement--;
        curr = Math.min(curr, index);
        return map.get(index).pop();
    }
}
