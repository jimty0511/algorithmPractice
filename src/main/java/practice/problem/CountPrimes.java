package practice.problem;

import java.util.ArrayList;
import java.util.List;

// 204. Count Primes
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }

    public List<Integer> getAllPrime(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = i; j >= 1; j--) {
                if (i % j == 0)
                    count += 1;
            }
            if (count == 2)
                result.add(i);
        }
        return result;
    }
}
