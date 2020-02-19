package practice.lintcode;

import java.util.HashSet;
import java.util.Set;

// 702. Concatenated String with Uncommon Characters of Two Strings
public class ConcatenatedStringWithUncommonCharactersOfTwoStrings {
    /**
     * @param s1: the 1st string
     * @param s2: the 2nd string
     * @return: uncommon characters of given strings
     */
    public String concatenetedString(String s1, String s2) {
        // write your code here
        Set<Character> set = new HashSet<>();
        for (char c : s2.toCharArray())
            set.add(c);
        StringBuilder sb = new StringBuilder();
        Set<Character> set2 = new HashSet<>();
        for (char c : s1.toCharArray()) {
            if (!set.contains(c))
                sb.append(c);
            else
                set2.add(c);
        }
        for (char c : s2.toCharArray()) {
            if (!set2.contains(c))
                sb.append(c);
        }
        return sb.toString();
    }
}
