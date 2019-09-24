package practice.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1125. Smallest Sufficient Team
public class SmallestSufficientTeam {
    List<Integer> res = new ArrayList<>();

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> idx = new HashMap<>();
        int n = 0;
        for (String s : req_skills)
            idx.put(s, n++);
        int[] ppl = new int[people.size()];
        for (int i = 0; i < ppl.length; i++) {
            for (String s : people.get(i)) {
                int skill = idx.get(s);
                ppl[i] += 1 << skill;
            }
        }
        helper(0, ppl, new ArrayList<>(), n);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);
        return ans;
    }

    private void helper(int cur, int[] ppl, List<Integer> tmpRes, int n) {
        if (cur == (1 << n) - 1) {
            if (res.size() == 0 || tmpRes.size() < res.size())
                res = new ArrayList<>(tmpRes);
            return;
        }
        if (res.size() != 0 && res.size() < tmpRes.size())
            return;
        int zeroPos = 0;
        while (((cur >> zeroPos) & 1) == 1)
            zeroPos++;
        for (int i = 0; i < ppl.length; i++) {
            int per = ppl[i];
            if (((per >> zeroPos) & 1) == 1) {
                tmpRes.add(i);
                helper(cur | per, ppl, tmpRes, n);
                tmpRes.remove(tmpRes.size() - 1);
            }
        }
    }
}
