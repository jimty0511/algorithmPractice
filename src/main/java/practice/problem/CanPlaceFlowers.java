package practice.problem;

// 605. Can Place Flowers
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length && count < n; i++) {
            if (flowerbed[i] == 0) {
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                if (next == 0 && prev == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }

    public boolean canPlaceFlowersTwo(int[] flowerbed, int n) {
        int count = 1, res = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0)
                count++;
            else {
                res += (count - 1) / 2;
                count = 0;
            }
        }
        if (count != 0)
            res += count / 2;
        return res >= n;
    }
}
