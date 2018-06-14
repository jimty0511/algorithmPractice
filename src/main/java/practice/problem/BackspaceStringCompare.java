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
}
