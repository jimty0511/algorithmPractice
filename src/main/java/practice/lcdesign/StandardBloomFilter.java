package practice.lcdesign;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// 556. Standard Bloom Filter
// Chapter 8
public class StandardBloomFilter {

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

    BitSet bitSet;
    int k;
    List<HashFunc> hashFuncs;

    /*
     * @param k: An integer
     */
    public StandardBloomFilter(int k) {
        // do intialization if necessary
        this.k = k;
        hashFuncs = new ArrayList<>();
        for (int i = 0; i < k; i++)
            hashFuncs.add(new HashFunc(100000 + i, 2 * i + 3));
        bitSet = new BitSet(100000 + k);
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        // write your code here
        for (int i = 0; i < k; i++) {
            int position = hashFuncs.get(i).hash(word);
            bitSet.set(position);
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
            if (!bitSet.get(pos))
                return false;
        }
        return true;
    }
}
