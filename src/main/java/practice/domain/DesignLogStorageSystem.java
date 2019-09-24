package practice.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 635. Design Log Storage System
public class DesignLogStorageSystem {

    public DesignLogStorageSystem() {

    }

    List<String[]> timestamps = new LinkedList<>();
    List<String> units = Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second");
    int[] indices = new int[]{4, 7, 10, 13, 16, 19};

    public void put(int id, String timestamp) {
        timestamps.add(new String[]{Integer.toString(id), timestamp});
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new ArrayList<>();
        int idx = indices[units.indexOf(gra)];
        for (String[] timestamp : timestamps) {
            if (timestamp[1].substring(0, idx).compareTo(s.substring(0, idx)) >= 0 &&
                    timestamp[1].substring(0, idx).compareTo(e.substring(0, idx)) <= 0)
                res.add(Integer.parseInt(timestamp[0]));
        }
        return res;
    }
}
