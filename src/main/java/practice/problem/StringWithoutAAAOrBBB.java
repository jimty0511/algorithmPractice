package practice.problem;

// 984. String Without AAA or BBB
public class StringWithoutAAAOrBBB {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder(A + B);
        while (A + B > 0) {
            String s = sb.toString();
            if (s.endsWith("aa")) {
                sb.append("b");
                B--;
            } else if (s.endsWith("bb")) {
                sb.append("a");
                A--;
            } else if (A > B) {
                sb.append("a");
                A--;
            } else {
                sb.append("b");
                B--;
            }
        }
        return sb.toString();
    }
}
