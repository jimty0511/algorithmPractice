package practice.problem;

// 75. Sort Colors
public class SortColors {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1;
        for (int i = 0; i < two; i++) {
            while (nums[i] == 2 && i < two) {
                int temp = nums[i];
                nums[i] = nums[two];
                nums[two--] = temp;
            }
            while (nums[i] == 0 && i > zero) {
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero++] = temp;
            }
        }
    }

    public void sortColorsOnePass(int[] nums) {
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1++] = 0;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2--] = 2;
                index--;
            }
            index++;
        }
    }

    public void sortColorsOnePassTwo(int[] nums) {
        int left = 0, right = nums.length - 1, index = 0;
        while (index < nums.length) {
            if (nums[index] == 0 && index > left) {
                nums[index] = nums[left];
                nums[left] = 0;
                left++;
            } else if (nums[index] == 2 && index < right) {
                nums[index] = nums[right];
                nums[right] = 2;
                right--;
            } else
                index++;
        }
    }
}
