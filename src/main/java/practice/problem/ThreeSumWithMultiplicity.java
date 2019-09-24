package practice.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 923. 3Sum With Multiplicity
public class ThreeSumWithMultiplicity {
    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, mod = (int) 1e9 + 7;
        for (int i = 0; i < A.length; i++) {
            res = (res + map.getOrDefault(target - A[i], 0)) % mod;
            for (int j = 0; j < i; j++) {
                int temp = A[i] + A[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return res;
    }

    public int threeSumMultiTwo(int[] A, int target) {
        Arrays.sort(A);
        int mod = (int) 1e9 + 7;
        int ans = 0;
        for (int i = 0; i < A.length - 2; i++) {
            long cnt = 0;
            int l = i + 1, r = A.length - 1;
            while (l < r) {
                if (A[i] + A[l] + A[r] > target)
                    r--;
                else if (A[i] + A[l] + A[r] < target)
                    l++;
                else {
                    if (A[l] != A[r]) {
                        long cntL = 1, cntR = 1;
                        while (l + 1 < r && A[l] == A[l + 1]) {
                            cntL++;
                            l++;
                        }
                        while (l < r - 1 && A[r] == A[r - 1]) {
                            cntR++;
                            r--;
                        }
                        cnt += (cntL * cntR) % mod;
                        l++;
                        r--;
                    } else {
                        long n = r - l + 1;
                        cnt += (n * (n - 1) / 2) % mod;
                        break;
                    }
                }
            }
            ans = (int) (ans + cnt) % mod;
        }
        return ans;
    }
}
