package practice.lintcode;

import java.util.*;

// 1694. Monster Hunter
public class MonsterHunter {
    /**
     * @param atk1: the active ATK
     * @param atk2: the secondary ATK
     * @return: The minimal damage you will suffer
     */
    public int killMonster(int[] atk1, int[] atk2) {
        // Write your code here
        List<Integer> one = new ArrayList<>(), two = new ArrayList<>();
        one.add(0);
        two.add(0);
        for (int i = 0; i < atk1.length; i++) {
            one.add(atk1[i]);
            two.add(atk2[i]);
        }
        one.add(0);
        two.add(0);
        int res = 0;
        while (one.size() > 2) {
            int min = Integer.MAX_VALUE, idx = -1, len = one.size();
            for (int i = 1; i < len - 1; i++) {
                int sum = one.get(i) + two.get(i - 1) + two.get(i + 1);
                if (sum < min) {
                    min = sum;
                    idx = i;
                }
            }
            res += min;
            one.remove(idx);
            two.remove(idx);
        }
        res += one.get(0);
        return res;
    }

    /**
     * @param atk1: the active ATK
     * @param atk2: the secondary ATK
     * @return: The minimal damage you will suffer
     */
    public int killMonsterTwo(int[] atk1, int[] atk2) {
        // Write your code here
        List<Integer> one = new ArrayList<>(), two = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        one.add(0);
        two.add(0);
        for (int i = 0; i < atk1.length; i++) {
            one.add(atk1[i]);
            two.add(atk2[i]);
        }
        one.add(0);
        two.add(0);
        dfs(one, two, 0, map);
        return res;
    }

    private int res = Integer.MAX_VALUE;

    private int dfs(List<Integer> one, List<Integer> two, int curSum, Map<String, Integer> map) {
        if (one.size() == 2) {
            res = Math.min(curSum, res);
            return curSum;
        }
        String curStr = one.toString() + two.toString();
        int len = one.size(), min = Integer.MAX_VALUE;
        for (int i = 1; i < len - 1; i++) {
            int sum = one.get(i) + two.get(i - 1) + two.get(i + 1);
            int tmpOne = one.get(i), tmpTwo = two.get(i);
            one.remove(i);
            two.remove(i);
            int total = curSum + sum;
            dfs(one, two, total, map);
            min = Math.min(min, total);
            one.add(i, tmpOne);
            two.add(i, tmpTwo);
        }
        return min;
    }

    private int dfsTwo(int[] one, int[] two, boolean[] used, Map<String, Integer> map) {
        String curStr = Arrays.toString(used);
        if (map.containsKey(curStr))
            return map.get(curStr);
        int len = one.length, min = Integer.MAX_VALUE;
        for (int idx = 1; idx < len - 1; idx++) {
            if (used[idx])
                continue;
            int i = idx - 1, j = idx + 1;
            while (i > 0 && used[i])
                i--;
            while (j < len - 1 && used[j])
                j++;
            int sum = two[i] + one[idx] + two[j];
            used[idx] = true;
            sum += dfsTwo(one, two, used, map);
            min = Math.min(min, sum);
            used[idx] = false;
        }
        map.put(curStr, min == Integer.MAX_VALUE ? 0 : min);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int killMonsterThree(int[] atk1, int[] atk2) {
        // Write your code here
        int len = atk1.length;
        int[] one = new int[len + 2], two = new int[len + 2];
        for (int i = 0; i < atk1.length; i++) {
            one[i + 1] = atk1[i];
            two[i + 1] = atk2[i];
        }
        one[0] = one[len + 1] = 0;
        two[0] = two[len + 1] = 0;
        int[][] memo = new int[len + 2][len + 2];
        int res = dfsThree(one, two, memo, 0, len + 1);
        return res;
    }

    private int dfsThree(int[] one, int[] two, int[][] memo, int left, int right) {
        if (left + 1 == right)
            return 0;
        if (memo[left][right] > 0)
            return memo[left][right];
        int ans = Integer.MAX_VALUE;
        for (int i = left + 1; i < right; i++) {
            int sum = two[left] + one[i] + two[right];
            int lefPart = dfsThree(one, two, memo, left, i);
            int rightPart = dfsThree(one, two, memo, i, right);
            ans = Math.min(ans, sum + lefPart + rightPart);
        }
        memo[left][right] = ans;
        return ans;
    }

    public int killMonsterDp(int[] atk1, int[] atk2) {
        // Write your code here
        int len = atk1.length;
        int[] one = new int[len + 2], two = new int[len + 2];
        for (int i = 0; i < atk1.length; i++) {
            one[i + 1] = atk1[i];
            two[i + 1] = atk2[i];
        }
        one[0] = one[len + 1] = 0;
        two[0] = two[len + 1] = 0;
        int[][] dp = new int[len + 2][len + 2];
        for (int j = 1; j <= len; j++) {
            for (int i = j; i >= 1; i--) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], two[i - 1] + one[k] + two[j + 1] + dp[i][k - 1] + dp[k + 1][j]);
                }
            }
        }
        return dp[1][len];
    }
}
