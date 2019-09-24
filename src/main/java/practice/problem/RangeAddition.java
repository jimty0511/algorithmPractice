package practice.problem;

// 370. Range Addition
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int add[] = new int[length + 1];
        int res[] = new int[length];
        for (int[] update : updates) {
//            int first = update[0];
//            int second = update[1];
//            int third = update[2];
            add[update[0]] += update[2];
            add[update[1] + 1] -= update[2];
        }
        res[0] = add[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = add[i] + res[i - 1];
        }
        return res;
    }
}
