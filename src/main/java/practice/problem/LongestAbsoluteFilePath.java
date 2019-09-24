package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 388. Longest Absolute File Path
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int result = 0;
        String[] strings = input.split("\n");
        for (String s : strings) {
            int level = s.lastIndexOf('\t') + 1;
            int len = s.length() - level;
            if (s.contains("."))
                result = Math.max(result, map.get(level) + len);
            else
                map.put(level + 1, map.get(level) + len + 1);
        }
        return result;
    }

    public int lengthLongestPathTwo(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int max = 0;
        for (String s : paths) {
            int level = s.lastIndexOf("\t") + 1;
            int len = s.length() - level;
            if (s.contains("."))
                max = Math.max(max, stack[level] + len);
            else
                stack[level + 1] = stack[level] + len + 1;
        }
        return max;
    }
}
