package practice.problem;

// 875. Koko Eating Bananas
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1, right = 0;
        for (int p : piles)
            right = Math.max(right, p);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, mid, H)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canEatAll(int[] piles, int mid, int H) {
        int hour = 0;
        for (int p : piles) {
            hour += p / mid;
            if (p % mid != 0)
                hour++;
        }
        return hour <= H;
    }
}
