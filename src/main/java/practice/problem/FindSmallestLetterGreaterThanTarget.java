package practice.problem;

// 744. Find Smallest Letter Greater Than Target
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length, i = 0, j = n - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (letters[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i == n ? letters[0] : letters[i];
    }
}
