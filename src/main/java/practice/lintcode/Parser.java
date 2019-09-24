package practice.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 790. Parser
public class Parser {
    public boolean canBeGenerated(String[] generator, char startSymbol, String symbolString) {
        // Write  your code here.
        Map<Character, List<String>> map = new HashMap<>();
        for (String g : generator) {
            char key = g.charAt(0);
            String val = g.substring(5);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(val);
        }
        String start = String.valueOf(startSymbol);
        return helper(start, symbolString, map);
    }

    private boolean helper(String start, String target, Map<Character, List<String>> map) {
        if (start.length() > target.length())
            return false;
        if (start.equals(target))
            return true;
        for (int i = 0; i < start.length(); i++) {
            char cur = start.charAt(i);
            if (cur >= 'A' && cur <= 'Z') {
                for (String s : map.get(cur)) {
                    String tmp = "";
                    if (i > 0)
                        tmp = start.substring(0, i);
                    tmp += s;
                    if (i + 1 < start.length())
                        tmp += start.substring(i + 1);
                    if (helper(tmp, target, map))
                        return true;
                }
            }
        }
        return false;
    }
}
