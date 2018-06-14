package practice.problem;

import java.util.*;

// 582. Kill Process
public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if (kill == 0) return pid;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int d : ppid) {
            map.putIfAbsent(d, new ArrayList<>());
        }
        for (int i = 0; i < pid.size(); i++) {
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int temp = queue.remove();
            res.add(temp);
            if (map.containsKey(temp)) {
                List<Integer> list = map.get(temp);
                for (int d : list) {
                    queue.add(d);
                }
            }
        }
        return res;
    }
}
