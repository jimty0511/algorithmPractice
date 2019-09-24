package practice.problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 762. Prime Number of Set Bits in Binary Representation
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        int count = 0;
        for (int i = L; i <= R; i++) {
            count += primes.contains(Integer.bitCount(i)) ? 1 : 0;
        }
        return count;
    }

    public int countPrimeSetBitsTwo(int L, int R) {
        int sum = 0;
        while (L <= R) {
            int x = L;
            int count = 0;
            while (L != 0) {
                if ((L & 1) == 1)
                    count++;
                L >>= 1;
            }
            L = x + 1;
            if (isPrime(count))
                sum++;
        }
        return sum;
    }

    private boolean isPrime(int n) {
        if (n < 2 || n % 2 == 0)
            return n == 2;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
