package practice.problem;

import practice.domain.Interval;

import java.util.Arrays;

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
}
