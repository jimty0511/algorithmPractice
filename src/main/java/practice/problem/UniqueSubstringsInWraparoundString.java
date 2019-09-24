package practice.problem;

// 467. Unique Substrings in Wraparound String
public class UniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int max = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25))
                max++;
            else
                max = 1;
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], max);
        }
        int sum = 0;
        for (int n : count)
            sum += n;
        return sum;
    }
}