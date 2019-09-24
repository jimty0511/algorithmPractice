package practice.problem;

// 724. Find Pivot Index
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int sum = 0, leftSum = 0;
        for (int n : nums) {
            sum += n;
        }
//        for (int i = 0; i < nums.length; i++) {
//            if (leftSum == sum - leftSum - nums[i])
//                return i;
//            leftSum += nums[i];
//        }
        for (int i = 0; i < nums.length; leftSum += nums[i++]) {
            if (leftSum * 2 == sum - nums[i])
                return i;
        }
        return -1;
    }

    public int pivotIndexTwo(int[] nums) {
        int sum = 0, left = 0;
        for (int n : nums)
            sum += n;
        for (int i = 0; i < nums.length; i++) {
            if (left * 2 == sum - nums[i])
                return i;
            left += nums[i];
        }
        return -1;
    }
}
