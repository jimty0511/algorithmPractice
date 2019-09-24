package practice.problem;

import java.util.Arrays;

// 1024. Video Stitching
public class VideoStitching {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        int end = 0, count = 0, i = 0;
        while (i < clips.length) {
            if (clips[i][0] > end)
                return -1;
            int newEnd = end;
            while (i < clips.length && clips[i][0] <= end)
                newEnd = Math.max(newEnd, clips[i++][1]);
            count++;
            end = newEnd;
            if (end >= T)
                return count;
        }
        return -1;
    }
}
