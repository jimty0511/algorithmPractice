package practice.problem;

// 557. Reverse Words in a String III
public class ReverseWordsInAStringIII {
    public String reverseWordsIII(String s) {
        String[] splitedString = s.split(" ");
        for (int i = 0; i < splitedString.length; i++) {
            splitedString[i] = new StringBuilder(splitedString[i]).reverse().toString();
        }
        StringBuilder result = new StringBuilder();
        for (String str : splitedString) {
            result.append(str + " ");
        }
        return result.toString().trim();
    }

    public String reverseWordsIIITwo(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == ' ') {
                reverseString(chars, start, i - 1);
                start = i + 1;
            }
        }
        reverseString(chars, start, s.length() - 1);
        return new String(chars);
    }

    private void reverseString(char[] s, int l, int r) {
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
