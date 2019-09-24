package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 658. Find K Closest Elements
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++)
            res.add(arr[left + i]);
        return res;
    }

    public List<Integer> findClosestElementsTwo(int[] arr, int k, int x) {
        int low = 0, high = arr.length - 1;
        while (high - low >= k) {
            if (Math.abs(arr[low] - x) > Math.abs(arr[high] - x))
                low++;
            else
                high--;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = low; i <= high; i++)
            res.add(arr[i]);
        return res;
    }
}
