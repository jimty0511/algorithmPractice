package practice.problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 893. Groups of Special-Equivalent Strings
public class GroupsOfSpecialEquivalentStrings {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s : A) {
            int[] odd = new int[26], even = new int[26];
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1)
                    odd[s.charAt(i) - 'a']++;
                else
                    even[s.charAt(i) - 'a']++;
            }
            String sig = Arrays.toString(odd) + Arrays.toString(even);
            set.add(sig);
        }
        return set.size();
    }
}
