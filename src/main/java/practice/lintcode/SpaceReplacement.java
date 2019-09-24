package practice.lintcode;

// 212. Space Replacement
public class SpaceReplacement {
    public int replaceBlank(char[] string, int length) {
        // write your code here
        if (length == 0)
            return 0;
        int num = 0;
        for (char c : string) {
            if (c == ' ')
                num++;
        }
        int len = length + num * 2;
        int j = 1;
        for (int i = length - 1; i >= 0; i--) {
            if (string[i] != ' ') {
                string[len - j] = string[i];
                j++;
            } else {
                string[len - j] = '0';
                j++;
                string[len - j] = '2';
                j++;
                string[len - j] = '%';
                j++;
            }
        }
        return len;
    }
}
