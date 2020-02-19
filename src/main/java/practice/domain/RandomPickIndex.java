package practice.domain;

import java.util.Random;

// 398. Random Pick Index
public class RandomPickIndex {

    int[] nums;
    Random ran;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        ran = new Random();
    }

    public int pick(int target) {
        int total = 0, res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int x = ran.nextInt(++total);
                res = x == 0 ? i : res;
            }
        }
        return res;
    }
}
