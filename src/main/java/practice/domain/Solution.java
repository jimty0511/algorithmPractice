package practice.domain;

// 384. Shuffle an Array
public class Solution {

    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] random = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int r = (int) (Math.random() * (i + 1));
            random[i] = random[r];
            random[r] = nums[i];
        }
        return random;
    }
}
