package practice.problem;

// 1017. Convert to Base -2
public class ConvertToBaseNeg2 {
    public String baseNeg2(int N) {
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            sb.append(N & 1);
            N = -(N >> 1);
        }
        return sb.length() > 0 ? sb.reverse().toString() : "0";
    }

    public String basePos2(int N) {
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            sb.append(N & 1);
            N = N >> 1;
        }
        return sb.length() > 0 ? sb.reverse().toString() : "0";
    }
}
