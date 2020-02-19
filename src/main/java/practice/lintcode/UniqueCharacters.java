package practice.lintcode;

// 157. Unique Characters
public class UniqueCharacters {
    /*
     * @param str: A string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        int[] cnt = new int[256];
        for (char c : str.toCharArray()) {
            if (++cnt[c] > 1)
                return false;
        }
        return true;
    }
}
