package practice.problem;

// 799. Champagne Tower
public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] res = new double[101];
        res[0] = poured;
        for (int row = 1; row <= query_row; row++) {
            for (int i = row; i >= 0; i--) {
                res[i] = Math.max(0.0, (res[i] - 1) / 2);
                res[i + 1] += res[i];
            }
        }
        return Math.min(res[query_glass], 1.0);
    }

    public double champagneTowerTwo(int poured, int query_row, int query_glass) {
        double[][] res = new double[102][102];
        res[0][0] = poured;
        for (int r = 0; r <= query_row; r++) {
            for (int c = 0; c <= r; c++) {
                double q = (res[r][c] - 1.0) / 2.0;
                if (q > 0) {
                    res[r + 1][c] += q;
                    res[r + 1][c + 1] += q;
                }
            }
        }
        return Math.min(1.0, res[query_row][query_glass]);
    }
}
