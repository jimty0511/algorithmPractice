package practice.problem;

// 991. Broken Calculator
public class BrokenCalculator {
    public int brokenCalc(int X, int Y) {
        int res = 0;
        while (Y > X) {
            Y = Y % 2 == 0 ? Y / 2 : Y + 1;
            res++;
        }
        return res + X - Y;
    }
}
