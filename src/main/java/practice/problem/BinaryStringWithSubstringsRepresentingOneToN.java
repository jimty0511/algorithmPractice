package practice.problem;

// 1016. Binary String With Substrings Representing 1 To N
public class BinaryStringWithSubstringsRepresentingOneToN {
    public boolean queryString(String S, int N) {
        for (int i = 1; i <= N; i++) {
            String b = Integer.toBinaryString(i);
            if (!S.contains(b))
                return false;
        }
        return true;
    }
}
