package practice.problem;

import java.util.*;

// 621. Task Scheduler
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0, maxCount = 0;
        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A'])
                maxCount++;
            else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        return tasks.length + idles;
    }

    public int leastIntervalTwo(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char t : tasks)
            map.put(t, map.getOrDefault(t, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        int count = 0;
        while (!pq.isEmpty()) {
            int k = n + 1;
            List<Map.Entry<Character, Integer>> tmp = new ArrayList<>();
            while (k > 0 && !pq.isEmpty()) {
                Map.Entry<Character, Integer> entry = pq.poll();
                entry.setValue(entry.getValue() - 1);
                tmp.add(entry);
                k--;
                count++;
            }
            for (Map.Entry<Character, Integer> e : tmp) {
                if (e.getValue() > 0)
                    pq.offer(e);
            }
            if (pq.isEmpty())
                break;
            count += k;
        }
        return count;
    }

    public int leastIntervalThree(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char c : tasks)
            cnt[c - 'A']++;
        Arrays.sort(cnt);
        int firstMaxIdx = 25;
        while (firstMaxIdx >= 0 && cnt[firstMaxIdx] == cnt[25])
            firstMaxIdx--;
        return Math.max(tasks.length, (cnt[25] - 1) * (n + 1) + (25 - firstMaxIdx));
    }

    public int leastIntervalFour(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char c : tasks)
            cnt[c - 'A']++;
        Arrays.sort(cnt);
        int maxVal = cnt[25] - 1, idleSlots = maxVal * n;
        for (int i = 24; i >= 0 && cnt[i] > 0; i--) {
            idleSlots -= Math.min(cnt[i], maxVal);
        }
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}
