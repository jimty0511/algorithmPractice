package practice.problem;

import java.util.Arrays;

// 881. Boats to Save People
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        for (int low = 0, high = people.length - 1; low <= high; high--, ans++) {
            if (people[low] + people[high] <= limit)
                low++;
        }
        return ans;

//        int left = 0, right = people.length - 1, ans = 0;
//        Arrays.sort(people);
//        while (left <= right) {
//            if (people[left] + people[right] <= limit)
//                left++;
//            right--;
//            ans++;
//        }
//        return ans;
    }
}
