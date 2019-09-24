package practice.lintcode;

// LintCode 734. Number of Subsequences of Form a^i b^j c^k
public class NumberOfSubsequencesOfFormaibjck {
    public int countSubsequences(String source) {
        // write your code here
        int aCount = 0, bCount = 0, cCount = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == 'a') {
                aCount = 1 + 2 * aCount;
            } else if (source.charAt(i) == 'b') {
                bCount = aCount + 2 * bCount;
            } else if (source.charAt(i) == 'c') {
                cCount = bCount + 2 * cCount;
            }
        }
        return cCount;
    }
}
