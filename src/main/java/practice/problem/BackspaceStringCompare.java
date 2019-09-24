package practice.problem;

// 844. Backspace String Compare
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        return checkString(S).equals(checkString(T));
    }

    private String checkString(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '#')
                sb.append(c);
            else if (sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public boolean backspaceCompareTwo(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        while (true) {
            for (int back = 0; i >= 0 && (back > 0 || S.charAt(i) == '#'); i--)
                back += S.charAt(i) == '#' ? 1 : -1;
            for (int back = 0; j >= 0 && (back > 0 || T.charAt(j) == '#'); j--)
                back += T.charAt(j) == '#' ? 1 : -1;
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                return i == -1 && j == -1;
            }
        }
    }

    public boolean backspaceCompareThree(String S, String T) {
        int count1 = 0, count2 = 0;
        for (int p1 = S.length() - 1, p2 = T.length() - 1; p1 >= 0 || p2 >= 0; p1--, p2--) {
            while (p1 >= 0 && (count1 != 0 || S.charAt(p1) == '#')) {
                if (S.charAt(p1) == '#')
                    count1++;
                else
                    count1--;
                p1--;
            }
            while (p2 >= 0 && (count2 != 0 || T.charAt(p2) == '#')) {
                if (T.charAt(p2) == '#')
                    count2++;
                else
                    count2--;
                p2--;
            }
            if (p1 < 0 && p2 < 0)
                return true;
            if (p1 < 0 || p2 < 0)
                return false;
            if (S.charAt(p1) != T.charAt(p2))
                return false;
        }
        return true;
    }

    public boolean backspaceCompareFour(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int countS = 0, countT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (countS > 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#')
                    countS++;
                else
                    countS--;
                i--;
            }
            char left = i < 0 ? '@' : S.charAt(i);
            while (j >= 0 && (countT > 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#')
                    countT++;
                else
                    countT--;
                j--;
            }
            char right = j < 0 ? '@' : T.charAt(j);
            if (left != right)
                return false;
            i--;
            j--;
        }
        return true;
    }
}
