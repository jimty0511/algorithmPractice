package practice.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 895. Maximum Frequency Stack
public class MaximumFrequencyStack {

    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> m;
    int maxFreq;

    public MaximumFrequencyStack() {
        freq = new HashMap<>();
        m = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        maxFreq = Math.max(maxFreq, f);
        if (!m.containsKey(f))
            m.put(f, new Stack<>());
        m.get(f).push(x);
    }

    public int pop() {
        int x = m.get(maxFreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (m.get(maxFreq).size() == 0)
            maxFreq--;
        return x;
    }
}
