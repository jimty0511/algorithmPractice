package practice.problem;

// 640. Solve the Equation
public class SolveTheEquation {
    public String solveEquation(String equation) {
        int[] res = evaluate(equation.split("=")[0]),
                res2 = evaluate(equation.split("=")[1]);
        res[0] -= res2[0];
        res[1] = res2[1] - res[1];
        if (res[0] == 0 && res[1] == 0)
            return "Infinite solutions";
        if (res[0] == 0)
            return "No solution";
        return "x=" + res[1] / res[0];
    }

    private int[] evaluate(String exp) {
        String[] tokens = exp.split("(?=[-+])");
        int[] res = new int[2];
        for (String token : tokens) {
            if (token.equals("+x") || token.equals("x"))
                res[0] += 1;
            else if (token.equals("-x"))
                res[0] -= 1;
            else if (token.contains("x"))
                res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
            else
                res[1] += Integer.parseInt(token);
        }
        return res;
    }
}
