package practice.problem;

// 838. Push Dominoes
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        dominoes = 'L' + dominoes + 'R';
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 1; j < dominoes.length(); j++) {
            if (dominoes.charAt(j) == '.')
                continue;
            int between = j - i - 1;
            if (i > 0)
                sb.append(dominoes.charAt(i));
            if (dominoes.charAt(i) == dominoes.charAt(j)) {
                for (int k = 0; k < between; k++) {
                    sb.append(dominoes.charAt(i));
                }
            } else if (dominoes.charAt(i) == 'L' && dominoes.charAt(j) == 'R') {
                for (int k = 0; k < between; k++) {
                    sb.append('.');
                }
            } else {
                for (int k = 0; k < between / 2; k++)
                    sb.append('R');
                if (between % 2 == 1)
                    sb.append('.');
                for (int k = 0; k < between / 2; k++)
                    sb.append('L');
            }
            i = j;
        }
        return sb.toString();
    }

    public String pushDominoesTwo(String dominoes) {
        char[] chars = dominoes.toCharArray();
        int L = -1, R = -1;
        for (int i = 0; i <= dominoes.length(); i++) {
            if (i == chars.length || chars[i] == 'R') {
                if (R > L)
                    while (R < i)
                        chars[R++] = 'R';
                R = i;
            } else if (chars[i] == 'L') {
                if (L > R || (R == -1 && L == -1))
                    while (++L < i)
                        chars[L] = 'L';
                else {
                    L = i;
                    int low = R + 1, high = L - 1;
                    while (low < high) {
                        chars[low++] = 'R';
                        chars[high--] = 'L';
                    }
                }
            }
        }
        return new String(chars);
    }

    public String pushDominoesThree(String dominoes) {
        char[] chars = dominoes.toCharArray();
        int n = chars.length;
        int[] left = new int[n], right = new int[n];
        int f = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'R')
                f = n;
            else if (chars[i] == 'L')
                f = 0;
            else
                f = Math.max(f - 1, 0);
            left[i] = f;
        }
        f = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] == 'L')
                f = n;
            else if (chars[i] == 'R')
                f = 0;
            else
                f = Math.max(f - 1, 0);
            right[i] = -f;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int sum = left[i] + right[i];
            sb.append(sum > 0 ? 'R' : sum < 0 ? 'L' : '.');
        }
        return sb.toString();
    }
}
