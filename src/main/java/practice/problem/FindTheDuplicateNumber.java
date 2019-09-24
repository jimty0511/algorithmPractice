package practice.problem;

// 287. Find the Duplicate Number
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int point1 = nums[0];
        int point2 = slow;
        while (point1 != point2) {
            point1 = nums[point1];
            point2 = nums[point2];
        }
        return point1;
    }

    public int findDuplicateTwo(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}