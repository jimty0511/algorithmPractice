package practice.problem;

import java.util.LinkedList;
import java.util.Queue;

// 949. Largest Time for Given Digits
public class LargestTimeForGivenDigits {
    public String largestTimeFromDigits(int[] A) {
        Queue<String> q = new LinkedList<>();
        q.offer("");
        for (int n : A) {
            for (int size = q.size(); size > 0; size--) {
                String s = q.poll();
                for (int i = 0; i <= s.length(); i++) {
                    q.offer(s.substring(0, i) + n + s.substring(i));
                }
            }
        }
        String largest = "";
        for (String s : q) {
            s = s.substring(0, 2) + ":" + s.substring(2);
            if (s.charAt(3) < '6' && s.compareTo("24:00") < 0 && s.compareTo(largest) > 0)
                largest = s;
        }
        return largest;
    }
}
