package practice.problem;

import java.util.*;

// 681. Next Closest Time
public class NextClosestTime {
    int diff = Integer.MAX_VALUE;
    String result = "";

    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        set.add(Integer.parseInt(time.substring(0, 1)));
        set.add(Integer.parseInt(time.substring(1, 2)));
        set.add(Integer.parseInt(time.substring(3, 4)));
        set.add(Integer.parseInt(time.substring(4, 5)));
        if (set.size() == 1)
            return time;
        List<Integer> digits = new ArrayList<>(set);
        int minutes = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
        dfs(digits, "", 0, minutes);
        return result;
    }

    private void dfs(List<Integer> digits, String cur, int pos, int target) {
        if (pos == 4) {
            int m = Integer.parseInt(cur.substring(0, 2)) * 60 + Integer.parseInt(cur.substring(2, 4));
            if (m == target)
                return;
            int d = m - target > 0 ? m - target : 1440 + m - target;
            if (d < diff) {
                diff = d;
                result = cur.substring(0, 2) + ":" + cur.substring(2, 4);
            }
            return;
        }
        for (int i = 0; i < digits.size(); i++) {
            if (pos == 0 && digits.get(i) > 2)
                continue;
            if (pos == 1 && Integer.parseInt(cur) * 10 + digits.get(i) > 23)
                continue;
            if (pos == 2 && digits.get(i) > 5)
                continue;
            if (pos == 3 && Integer.parseInt(cur.substring(2)) * 10 + digits.get(i) > 59)
                continue;
            dfs(digits, cur + digits.get(i), pos + 1, target);
        }
    }


    public String nextClosestTimeTwo(String time) {
        char[] result = time.toCharArray();
        char[] digits = new char[]{result[0], result[1], result[3], result[4]};
        Arrays.sort(digits);
        result[4] = findNext(result[4], (char) ('9' + 1), digits);
        if (result[4] > time.charAt(4))
            return String.valueOf(result);

        result[3] = findNext(result[3], '5', digits);
        if (result[3] > time.charAt(3))
            return String.valueOf(result);

        result[1] = result[0] == '2' ? findNext(result[1], '3', digits) : findNext(result[1], (char) ('9' + 1), digits);
        if (result[1] > time.charAt(1))
            return String.valueOf(result);

        result[0] = findNext(result[0], '2', digits);
        return String.valueOf(result);
    }

    private char findNext(char current, char upperLimit, char[] digits) {
        if (current == upperLimit) {
            return digits[0];
        }
        int pos = Arrays.binarySearch(digits, current) + 1;
        while (pos < 4 && (digits[pos] > upperLimit || digits[pos] == current)) {
            pos++;
        }
        return pos == 4 ? digits[0] : digits[pos];
    }
}
