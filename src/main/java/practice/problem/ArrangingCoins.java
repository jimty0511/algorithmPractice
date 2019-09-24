package practice.problem;

// 441. Arranging Coins
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int count = 0, left = n;
        for (int i = 1; left >= i; i++) {
            count++;
            left -= i;
        }
        return count;
    }
}
