package practice.domain;

import java.util.HashMap;
import java.util.Map;

// 911. Online Election
public class TopVotedCandidate {

    int[] time;
    Map<Integer, Integer> map = new HashMap<>();

    public TopVotedCandidate(int[] persons, int[] times) {
        int n = persons.length, lead = -1;
        Map<Integer, Integer> count = new HashMap<>();
        time = times;
        for (int i = 0; i < n; i++) {
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if (i == 0 || count.get(persons[i]) >= count.get(lead))
                lead = persons[i];
            map.put(times[i], lead);
        }
    }

    public int q(int t) {
        int i = 0, j = time.length;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (time[mid] <= t) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return map.get(time[i - 1]);
    }
}
