package practice.problem;

import java.util.TreeSet;

// 683. K Empty Slots
public class KEmptySlots {
    public int kEmptySlots(int[] flowers, int k) {
        int[] days = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++)
            days[flowers[i] - 1] = i + 1;
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        for (int i = 1; right < days.length; i++) {
            if (days[i] < days[left] || days[i] <= days[right]) {
                if (i == right)
                    res = Math.min(res, Math.max(days[left], days[right]));   //we get a valid subarray
                left = i;
                right = k + 1 + i;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int kEmptySlotsTreeSet(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            int curr = flowers[i];
            Integer next = set.higher(curr);
            if (next != null && next - curr == k + 1)
                return i + 1;
            Integer pre = set.lower(curr);
            if (pre != null && curr - pre == k + 1)
                return i + 1;
            set.add(curr);
        }
        return -1;
    }
}
