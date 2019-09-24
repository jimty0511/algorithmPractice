package practice.problem;

import java.util.Arrays;

// 719. Find K-th Smallest Pair Distance
public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int N = nums.length;
        int low = 0, high = nums[N - 1] - nums[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0, maxDist = 0;
//            for (int i = 0, j = 0; j < N; j++) {
//                while (nums[j] - nums[i] > mid)
//                    i++;
//                if (i < j) {
//                    count += j - i;
//                    maxDist = Math.max(maxDist, nums[j] - nums[i]);
//                }
//            }
//            if (count == k)
//                return maxDist;
//            else if (count < k)
            for (int i = 0, j = 0; j < N; j++) {
                while (nums[j] - nums[i] > mid)
                    i++;
                count += j - i;
            }
            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public int smallestDistancePairTwo(int[] nums, int k) {
        Arrays.sort(nums);
        int[] arr = new int[nums[nums.length - 1] + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++)
                arr[nums[j] - nums[i]]++;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
            if (count >= k)
                return i;
        }
        return 0;
    }
}
