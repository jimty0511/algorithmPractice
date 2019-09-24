package practice.problem;

// 686. Repeated String Match
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if (sb.toString().contains(B))
            return count;
        if (sb.append(A).toString().contains(B))
            return count + 1;
        return -1;
    }
}
