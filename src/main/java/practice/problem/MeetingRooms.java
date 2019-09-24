package practice.problem;

import practice.domain.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

// 252. Meeting Rooms
public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null)
            return true;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end)
                return false;
        }
        return true;
    }

    public boolean canAttendMeetingsTm(Interval[] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }
        int room = 0;
        for (int v : map.values()) {
            room += v;
            if (room > 1)
                return false;
        }
        return true;
    }
}
