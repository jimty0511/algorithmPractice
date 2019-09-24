package practice.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 18. 4Sum
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        fourSumHelper(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private void fourSumHelper(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (tempList.size() == 4 && remain == 0 && !list.contains(tempList)) {
            list.add(new ArrayList<>(tempList));
        } else if (tempList.size() == 4) {
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] + nums[nums.length - 1] * (3 - tempList.size()) < remain)
                    continue;
                if (nums[i] * (4 - tempList.size()) > remain)
                    return;
                tempList.add(nums[i]);
                fourSumHelper(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    int len = 0;

    public List<List<Integer>> fourSumTwo(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return fourSumTwoHelper(nums, target, 4, 0);
    }

    private List<List<Integer>> fourSumTwoHelper(int[] nums, int target, int k, int index) {
        List<List<Integer>> res = new ArrayList<>();
        if (index > len)
            return res;
        if (k == 2) {
            int i = index, j = len - 1;
            while (i < j) {
                if (target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(target - nums[i]);
                    res.add(temp);
                    while (i < j && nums[i] == nums[i + 1])
                        i++;
                    while (i < j && nums[j - 1] == nums[j])
                        j--;
                    i++;
                    j--;
                } else if (target - nums[i] > nums[j])
                    i++;
                else {
                    j--;
                }
            }
        } else {
            for (int i = index; i < len - k + 1; i++) {
                List<List<Integer>> temp = fourSumTwoHelper(nums, target - nums[i], k - 1, i + 1);
                if (temp != null) {
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len - 1 && nums[i] == nums[i + 1])
                    i++;
            }
        }
        return res;
    }

    public List<List<Integer>> fourSumLikeThreeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int low = j + 1, high = nums.length - 1, sum = target - nums[i] - nums[j];
                        while (low < high) {
                            if (nums[low] + nums[high] == sum) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                                while (low < high && nums[low] == nums[low + 1])
                                    low++;
                                while (low < high && nums[high] == nums[high - 1])
                                    high--;
                                low++;
                                high--;
                            } else if (nums[low] + nums[high] < sum)
                                low++;
                            else
                                high--;
                        }
                    }
                }
            }
        }
        return res;
    }
}
