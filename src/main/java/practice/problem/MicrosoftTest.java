package practice.problem;

public class MicrosoftTest {
    public String solution(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int best_res = occurrences[0];

        for (int i = 1; i < 26; i++) {
            if (occurrences[i] > best_res) {
                best_char = (char) ((int) 'a' + i);
                best_res = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }

    public String riddleSolution(String riddle) {
        // write your code in Java SE 8
        if (riddle == null || riddle.length() == 0)
            return "";
        char[] chars = riddle.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                if (i == 0)
                    chars[i] = riddleHelper('?', chars[i + 1] - 'a');
                else if (i == chars.length - 1)
                    chars[i] = riddleHelper(chars[i + -1] - 'a', '?');
                else
                    chars[i] = riddleHelper(chars[i - 1] - 'a', chars[i + 1] - 'a');
            }
        }
        return new String(chars);
    }

    private char riddleHelper(int pre, int next) {
        int res = 0;
        while (res < 26) {
            if (res != pre && res != next) {
                break;
            }
            res++;
        }
        return (char) (res + 'a');
    }

    public int insert5Solution(int N) {
        // write your code in Java SE 8
        String number = String.valueOf(N);
        StringBuilder res = new StringBuilder();
        if (N < 0) {
            int i = number.length() - 1;
            while (i >= 0) {
                if (number.charAt(i) < '5') {
                    res.append(5);
                    break;
                }
                res.append(number.charAt(i--));
            }
            while (i >= 0)
                res.append(number.charAt(i--));
            res.reverse();
        } else {
            int i = 0;
            while (i < number.length()) {
                if (number.charAt(i) < '5') {
                    res.append(5);
                    break;
                }
                res.append(number.charAt(i++));
            }
            while (i < number.length())
                res.append(number.charAt(i++));
            if (Integer.parseInt(res.toString()) == N)
                res.append(5);
        }
        return Integer.parseInt(res.toString());
    }
}
