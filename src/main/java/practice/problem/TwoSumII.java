package practice.problem;

// 167. Two Sum II - Input array is sorted
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length == 0)
            return res;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int value = numbers[left] + numbers[right];
            if (value == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            } else if (value > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
