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

    public int countPrimesTwo(int n) {
        if (n <= 2)
            return 0;
        int ans = 1;
        boolean[] isPrime = new boolean[n];
        int upper = (int) Math.sqrt(n);
        for (int i = 3; i < n; i += 2) {
            if (isPrime[i])
                continue;
            ans++;
            if (i > upper)
                continue;
            for (int j = i * i; j < n; j = j + 2 * i)
                isPrime[j] = true;
        }
        return ans;
    }

    public int countPrimesThree(int n) {
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                for (int j = i; j <= (n - 1) / i; j++) {
                    isPrime[i * j] = true;
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
