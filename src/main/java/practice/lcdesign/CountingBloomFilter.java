package practice.lcdesign;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// 555. Counting Bloom Filter
// Chapter 8
public class CountingBloomFilter {

    class HashFunc {
        int cap, seed;

        public HashFunc(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(String value) {
            int res = 0;
            int n = value.length();
            for (int i = 0; i < n; i++) {
                res += seed * res + value.charAt(i);
                res %= cap;
            }
            return res;
        }
    }

    int[] bitSet;
    int k;
    List<HashFunc> hashFuncs;

    /*
     * @param k: An integer
     */
    public CountingBloomFilter(int k) {
        // do intialization if necessary
        this.k = k;
        hashFuncs = new ArrayList<>();
        for (int i = 0; i < k; i++)
            hashFuncs.add(new HashFunc(100000 + i, 2 * i + 3));
        bitSet = new int[100000 + k];
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        // write your code here
        for (int i = 0; i < k; i++) {
            int pos = hashFuncs.get(i).hash(word);
            bitSet[pos] += 1;
        }
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void remove(String word) {
        // write your code here
        for (int i = 0; i < k; i++) {
            int pos = hashFuncs.get(i).hash(word);
            bitSet[pos] -= 1;
        }
    }

    /*
     * @param word: A string
     * @return: True if contains word
     */
    public boolean contains(String word) {
        // write your code here
        for (int i = 0; i < k; i++) {
            int pos = hashFuncs.get(i).hash(word);
            if (bitSet[pos] <= 0)
                return false;
        }
        return true;
    }
}
