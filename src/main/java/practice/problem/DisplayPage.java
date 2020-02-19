package practice.problem;

import java.util.*;

// https://github.com/allaboutjst/airbnb
public class DisplayPage {
    public List<String> displayPages(List<String> input, int pageSize) {
        List<String> res = new ArrayList<>();
        Iterator<String> iter = input.iterator();
        Set<String> set = new HashSet<>();
        boolean reachEnd = false;
        int cnt = 0;
        while (iter.hasNext()) {
            String cur = iter.next();
            String id = cur.split(",")[0];
            if (!set.contains(id) || reachEnd) {
                res.add(cur);
                set.add(id);
                iter.remove();
                cnt++;
            }
            if (cnt == pageSize) {
                if (!input.isEmpty())
                    res.add(" ");
                set.clear();
                cnt = 0;
                reachEnd = false;
                iter = input.iterator();
            }
            if (!iter.hasNext()) {
                reachEnd = true;
                iter = input.iterator();
            }
        }
        return res;
    }

    public List<List<String>> displayPagesTwo(List<String> input, int pageSize) {
        List<List<String>> res = new ArrayList<>();
        if (input != null && input.size() > pageSize) {
            Queue<String> cur = new LinkedList<>();
            int idx = 0;
            for (int i = 0; i < Math.ceil((double) input.size() / pageSize); i++) {
                List<String> page = new ArrayList<>();
                Queue<String> next = new LinkedList<>();
                Set<String> visited = new HashSet<>();
                while (page.size() < pageSize) {
                    while (!cur.isEmpty() && page.size() < pageSize) {
                        String s = cur.poll();
                        if (visited.add(s.split(",")[0]))
                            page.add(s);
                        else
                            next.offer(s);
                    }
                    while (idx < input.size() && page.size() < pageSize) {
                        String s = input.get(idx++);
                        if (visited.add(s.split(",")[0]))
                            page.add(s);
                        else
                            next.offer(s);
                    }
                    if (!next.isEmpty()) {
                        cur.addAll(next);
                        next.clear();
                        visited.clear();
                    }
                    if (idx == input.size() && cur.isEmpty())
                        break;
                }
                res.add(page);
            }
        }
        if (input != null && input.size() <= pageSize)
            res.add(input);
        return res;
    }
}
