package practice.lcdesign;

// 128. Hash Function
public class HashFunction {
    /**
     * @param key:       A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        long res = 0;
        for (char c : key) {
            res = (res * 33 + (int) c) % HASH_SIZE;
        }
        return (int) res;
    }
}
