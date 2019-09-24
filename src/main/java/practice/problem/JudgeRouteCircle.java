package practice.problem;

// 657. Judge Route Circle || Robot Return to Origin
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int v = 0, h = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U')
                v++;
            else if (c == 'D')
                v--;
            else if (c == 'L')
                h++;
            else if (c == 'R')
                h--;
        }
        return v == 0 && h == 0;
    }
}
