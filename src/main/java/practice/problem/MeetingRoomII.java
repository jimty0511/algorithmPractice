package practice.problem;

import practice.domain.Interval;

import java.util.*;

// 253. Meeting Rooms II
public class MeetingRoomII {
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < starts.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        for (int i = 0, j = 0; i < starts.length; i++) {
            if (starts[i] < ends[j]) {
                rooms++;
            } else {
                j++;
            }
        }
        return rooms;
    }

    public int minMeetingRoomsTwo(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval curr = pq.poll();
            if (intervals[i].start >= curr.end) {
                curr.end = intervals[i].end;
            } else {
                pq.offer(intervals[i]);
            }
            pq.offer(curr);
        }
        return pq.size();
    }

    public int minMeetingRoomsTm(Interval[] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }
        int room = 0, k = 0;
        for (int v : map.values()) {
            k = Math.max(k, room += v);
        }
        return k;
    }

    public int[] minMeetingRoomsTmFindRange(Interval[] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }
        int max = Integer.MIN_VALUE, start = -1, end = -1, cnt = 0;
        for (int key : map.keySet()) {
            if (max == cnt) {
                end = key;
            }
            cnt += map.get(key);
            if (max < cnt) {
                max = cnt;
                start = key;
            }
        }
        return new int[]{start, end};
    }
}
