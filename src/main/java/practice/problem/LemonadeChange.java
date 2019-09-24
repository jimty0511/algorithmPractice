package practice.problem;

// 860. Lemonade Change
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int b : bills) {
            if (b == 5)
                five++;
            else if (b == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                ten--;
                five--;
            } else
                five -= 3;
            if (five < 0)
                return false;
        }
        return true;
    }
}
