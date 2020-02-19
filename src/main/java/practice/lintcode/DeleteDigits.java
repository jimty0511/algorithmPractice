package practice.lintcode;

// 182. Delete Digits
// Microsoft ladder
public class DeleteDigits {
    /**
     * @param A: A positive integer which has N digits, A is a string
     * @param k: Remove k digits
     * @return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        char[] res = new char[A.length()];
        int len = A.length() - k;
        int idx = 0;
        for (int i = 0; i < A.length(); i++) {
            while (idx > 0 && k > 0 && A.charAt(i) < res[idx - 1]) {
                idx--;
                k--;
            }
            res[idx++] = A.charAt(i);
        }
        int left = 0;
        while (left < len && res[left] == '0')
            left++;
        return left == len ? "0" : new String(res, left, len - left);
    }
}
