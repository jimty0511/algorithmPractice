package practice.problem;

import java.util.HashMap;
import java.util.Map;

// 914. X of a Kind in a Deck of Cards
public class XOfAKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int d : deck) {
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        for (int i : map.values()) {
            res = gcd(i, res);
        }
        return res > 1;
    }

    private int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}
