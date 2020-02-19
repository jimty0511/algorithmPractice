package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 825. Friends Of Appropriate Ages
public class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] numInAge = new int[121], sumInAge = new int[121];
        for (int a : ages)
            numInAge[a]++;
        for (int i = 1; i <= 120; i++)
            sumInAge[i] = numInAge[i] + sumInAge[i - 1];
        for (int i = 15; i <= 120; i++) {
            if (numInAge[i] == 0)
                continue;
            int count = sumInAge[i] - sumInAge[i / 2 + 7];
            res += count * numInAge[i] - numInAge[i]; //people will not friend request themselves, so  - numInAge[i]
        }
        return res;
    }

    public int numFriendRequestsTwo(int[] ages) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : ages)
            map.put(a, map.getOrDefault(a, 0) + 1);
        int res = 0;
        for (Integer a : map.keySet())
            for (Integer b : map.keySet()) {
                if (helper(a, b)) {
                    res += map.get(a) * (map.get(b) - (a == b ? 1 : 0));
                }
            }
        return res;
    }

    private boolean helper(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
    }
}
