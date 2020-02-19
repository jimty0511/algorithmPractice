package practice.lintcode;

import java.util.*;

// 1672. Poker
public class Poker {

    int res = 0;

    /**
     * @param cards:
     * @return: the minimal times to discard all cards
     */
    public int getAns(int[] cards) {
        // Write your code here
        Arrays.sort(cards);
        Map<Integer, Integer> map = new HashMap<>(), append = new HashMap<>();
        for (int c : cards)
            map.put(c, map.getOrDefault(c, 0) + 1);
        while (map.size() != 0) {
            Set<Integer> set = new HashSet<>(map.keySet());
//            for (int n : cards) {
//                if (map.get(n) == 0)
//                    continue;
//                else if (append.getOrDefault(n, 0) > 0) {
//                    map.put(n, map.get(n) - 1);
//                    append.put(n, append.get(n) - 1);
//                    append.put(n + 1, append.getOrDefault(n + 1, 0) + 1);
//                } else if (map.getOrDefault(n + 1, 0) > 0 && map.getOrDefault(n + 2, 0) > 0 &&
//                        map.getOrDefault(n + 3, 0) > 0 && map.getOrDefault(n + 4, 0) > 0) {
//                    map.put(n, map.get(n) - 1);
//                    map.put(n + 1, map.get(n + 1) - 1);
//                    map.put(n + 2, map.get(n + 2) - 1);
//                    map.put(n + 3, map.get(n + 3) - 1);
//                    map.put(n + 4, map.get(n + 4) - 1);
//                    append.put(n + 5, append.getOrDefault(n + 5, 0) + 1);
//                    res++;
//                }
//            }
            map = helper(map);
            for (int key : set) {
                if (map.get(key) > 0) {
                    res += 1;
                    map.remove(key);
                }
            }
            for (int key : set) {
                if (map.get(key) != null && map.get(key) <= 0)
                    map.remove(key);
            }
        }
        return res;
    }

    public Map<Integer, Integer> helper(Map<Integer, Integer> map) {
        // Write your code here
        String sum = buildBinary(map);
        while (sum.indexOf("11111") >= 0) {
            int idx = sum.indexOf("11111");
            int j = idx + 5;
            while (j < sum.length() && sum.charAt(j) == '1')
                j++;
            for (int i = idx; i < j; i++) {
                int num = sum.length() - i - 1;
                map.put(num, map.get(num) - 1);
            }
            sum = buildBinary(map);
            res++;
        }
        return map;
    }

    private String buildBinary(Map<Integer, Integer> map) {
        int binary = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > 0)
                binary |= 1 << key;
        }
        return Integer.toBinaryString(binary);
    }

    private int min;

    public int getAnsThree(int[] cards) {
        int[] newCards = new int[9];
        for (int card : cards)
            newCards[card - 1]++;
        min = newCards.length;
        dfs(newCards, 0);
        return min;
    }

    private void dfs(int[] cards, int sum) {
        boolean flag = cards[4] == 0;
        int index1 = 0, index2 = 8;
        for (int i = 3; i >= 0; i--)
            if (cards[i] == 0) {
                index1 = i;
                break;
            }
        for (int i = 5; i < 9; i++)
            if (cards[i] == 0) {
                index2 = i;
                break;
            }
        if (flag || !flag && (index2 - index1) <= 5) {
            int res = 0;
            for (int i = 0; i < cards.length; i++)
                if (cards[i] != 0)
                    res++;
            min = Math.min(min, res + sum);
            return;
        }
        A:
        for (int i = 0; i < 5; i++) {
            int j = i, count = 0;
            for (; j < cards.length; j++) {
                if (cards[j] == 0 && j - i < 5)
                    continue A;
                if (cards[j] == 0) {
                    count = j - i;
                } else if (j == cards.length - 1)
                    count = j - i + 1;
            }
            while (count != 4) {
                for (int k = i; k < i + count; k++)
                    cards[k]--;
                dfs(cards, 1 + sum);
                for (int k = i; k < i + count; k++)
                    cards[k]++;
                count--;
            }
        }
    }
}
