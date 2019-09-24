package practice.problem;

public class MakingAnagrams {
    public int makingAnagrams(String s1, String s2) {
        int i = 0, j = 0, res = 0;
        int[] count = new int[26];
        while (i < s1.length() || j < s2.length()) {
            if (i < s1.length()) {
                count[s1.charAt(i) - 'a']++;
            }
            if (j < s2.length()) {
                count[s2.charAt(j) - 'a']--;
            }
            i++;
            j++;
        }
        for (int n : count) {
            if (n != 0) {
                res += Math.abs(n);
            }
        }
        return res;
    }
}
