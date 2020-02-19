package practice.domain;

import java.util.TreeMap;

// 1146. Snapshot Array
public class SnapshotArray {

    TreeMap<Integer, Integer>[] arr;
    int snapId = 0;

    public SnapshotArray(int length) {
        arr = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new TreeMap<>();
            arr[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        arr[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        return arr[index].floorEntry(snap_id).getValue();
    }
}
