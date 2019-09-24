package practice.problem;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// 753. Cracking the Safe
public class CrackingTheSafe {
    public String crackSafe(int n, int k) {
        String strPwd = String.join("", Collections.nCopies(n, "0"));
        StringBuilder sbPwd = new StringBuilder(strPwd);
        Set<String> visited = new HashSet<>();
        visited.add(strPwd);
        int target = (int) Math.pow(k, n);
        helper(sbPwd, visited, target, n, k);
        return sbPwd.toString();
    }

    private boolean helper(StringBuilder pwd, Set<String> visited, int target, int n, int k) {
        if (visited.size() == target)
            return true;
        String lastDigit = pwd.substring(pwd.length() - n + 1);
        for (char ch = '0'; ch < '0' + k; ch++) {
            String newComb = lastDigit + ch;
            if (!visited.contains(newComb)) {
                visited.add(newComb);
                pwd.append(ch);
                if (helper(pwd, visited, target, n, k))
                    return true;
                visited.remove(newComb);
                pwd.deleteCharAt(pwd.length() - 1);
            }
        }
        return false;
    }
}
