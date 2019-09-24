package practice.problem;

// 990. Satisfiability of Equality Equations
public class SatisfiabilityOfEqualityEquations {
    int[] uf = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++)
            uf[i] = i;
        for (String e : equations) {
            if (e.charAt(1) == '=') {
                uf[find(e.charAt(0) - 'a')] = find(e.charAt(3) - 'a');
            }
        }
        for (String e : equations) {
            if (e.charAt(1) == '!' && find(e.charAt(0) - 'a') == find(e.charAt(3) - 'a'))
                return false;
        }
        return true;
    }

    private int find(int v) {
        while (v != uf[v]) {
            uf[v] = uf[uf[v]];
            v = uf[v];
        }
        return v;
    }
}
