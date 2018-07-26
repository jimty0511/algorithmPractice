package practice.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 811. Subdomain Visit Count
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : cpdomains) {
            String[] line = str.split(" ");
            int count = Integer.valueOf(line[0]);
            String[] domains = line[1].split("\\.");
            String temp = "";
            for (int i = domains.length - 1; i >= 0; i--) {
                temp = domains[i] + (temp.equals("") ? temp : "." + temp);
                if (!map.containsKey(temp)) {
                    map.put(temp, count);
                } else {
                    map.put(temp, map.get(temp) + count);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }
}
