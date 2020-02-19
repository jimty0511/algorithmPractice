package practice.lintcode;

import java.util.*;

// 1428. Keys and Rooms
public class KeysAndRooms {
    /**
     * @param rooms: a list of keys rooms[i]
     * @return: can you enter every room
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Write your code here
        Set<Integer> opened = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        opened.add(0);
        while (!q.isEmpty()) {
            int idx = q.poll();
            for (int key : rooms.get(idx)) {
                if (!opened.contains(key)) {
                    opened.add(key);
                    q.offer(key);
                }
            }
        }
        return opened.size() == rooms.size();
    }
}
