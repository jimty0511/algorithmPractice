package practice.problem;

import java.util.HashSet;
import java.util.Set;

// 771. Jewels and Stones
public class JewelsAndStones {
    public int numJewelsInStonesRex(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }

    public int numJewelsInStonesSet(String J, String S) {
        int res = 0;
        Set<Character> setJ = new HashSet();
        for (char j : J.toCharArray()) setJ.add(j);
        for (char s : S.toCharArray()) if (setJ.contains(s)) res++;
        return res;
    }
}
