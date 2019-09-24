package practice.problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 950. Reveal Cards In Increasing Order
public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            q.offer(i);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[q.poll()] = deck[i];
            q.offer(q.poll());
        }
        return res;
    }
}
