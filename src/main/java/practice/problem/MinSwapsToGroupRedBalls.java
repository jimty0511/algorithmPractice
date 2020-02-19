package practice.problem;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/discuss/interview-question/414660/
public class MinSwapsToGroupRedBalls {
    public int solution(String s) {
        List<Integer> idx = getRedIdx(s);
        int mid = idx.size() / 2;
        int min = 0;
        for (int i = 0; i < idx.size(); i++) {
            min += Math.abs(idx.get(mid) - idx.get(i)) - Math.abs(mid - i);
        }
        return min;
    }

    private List<Integer> getRedIdx(String s) {
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R')
                idx.add(i);
        }
        return idx;
    }
}
