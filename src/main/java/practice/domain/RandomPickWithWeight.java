package practice.domain;

import java.util.Random;

// 528. Random Pick with Weight
public class RandomPickWithWeight {

    Random random;
    int[] wSums;

//    public RandomPickWithWeight(int[] w) {
//        this.random = new Random();
//        for (int i = 1; i < w.length; i++)
//            w[i] += w[i - 1];
//        this.wSums = w;
//    }
//
//    public int pickIndex() {
//        int len = wSums.length;
//        int idx = random.nextInt(wSums[len - 1]) + 1;
//        int left = 0, right = len - 1;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (wSums[mid] == idx)
//                return mid;
//            else if (wSums[mid] < idx)
//                left = mid + 1;
//            else
//                right = mid;
//        }
//        return left;
//    }

    public RandomPickWithWeight(int[] w) {
        this.wSums = w;
        this.random = new Random();
        for (int i = 1; i < wSums.length; i++)
            wSums[i] += wSums[i - 1];
    }

    public int pickIndex() {
        int target = random.nextInt(wSums[wSums.length - 1]);
        int low = 0, high = wSums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target >= wSums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
